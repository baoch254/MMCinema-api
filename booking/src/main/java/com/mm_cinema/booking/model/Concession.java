package com.mm_cinema.booking.model;


import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Concession extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "category_id", unique = true)
    private CategoryItem category;
    @Column(length = 255)
    private String name;

    @Column
    private Integer price = 0;

    @Column
    private Integer quantity = 0;

    @Column(length = 255)
    private String description;

    @Column(name = "description_alt", length = 255)
    private String descriptionAlt;

    @Column(length = 255)
    private String thumbnail;
    @OneToMany(mappedBy = "concession")
    private List<BookingDetail> bookingDetails = new ArrayList<>();

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;


    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
