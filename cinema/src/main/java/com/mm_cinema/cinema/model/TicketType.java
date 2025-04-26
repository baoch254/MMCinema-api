package com.mm_cinema.cinema.model;


import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketType extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;

    @Column
    private Integer price = 0;

    @Column
    private Integer quantity = 0;

    @Column(name = "quantity_lock")
    private Integer quantityLock = 0;

    @Column(name = "quantity_sold")
    private Integer quantitySold = 0;

    @Column(name = "min_booking_per_ticket")
    private Integer minBookingPerTicket;

    @Column(name = "max_booking_per_ticket")
    private Integer maxBookingPerTicket;

    @OneToMany(mappedBy = "ticketType")
    private List<Seat> seats = new ArrayList<>();

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
