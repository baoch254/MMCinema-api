package com.mm_cinema.cinema.model;


import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinemas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cinema extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "api_cinema_id", nullable = false, unique = true, length = 255)
    private String apiCinemaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "city_name", length = 255)
    private String cityName;

    @Column(length = 255)
    private String address;

    @Column(length = 255)
    private String avatar;

    @Column(length = 255)
    private String logo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cineplex_id")
    private Cineplex cineplex;

    @Column(name = "cineplex_featured_note", length = 255)
    private String cineplexFeaturedNote;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "featured_note", length = 255)
    private String featuredNote;

    @Column(name = "index_mark")
    private Integer indexMark;

    @Column(name = "is_order_link")
    private Boolean isOrderLink = false;

    @Column
    private Float lat = 0.0f;

    @Column
    private Float lon = 0.0f;

    @Column(name = "rating_count")
    private Integer ratingCount = 0;

    @Column(name = "rating_value")
    private Float ratingValue = 0.0f;

    @Column(name = "short_name", length = 255)
    private String shortName;

    @Column(name = "url_rewrite", length = 255)
    private String urlRewrite;

    @OneToMany(mappedBy = "cinema")
    private List<Theater> theaters = new ArrayList<>();

    @OneToMany(mappedBy = "cinema")
    private List<Booking> bookings = new ArrayList<>();

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
