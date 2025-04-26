package com.mm_cinema.booking.model;


import com.mm_cinema.booking.model.enumeration.BookingStatus;
import com.mm_cinema.booking.model.enumeration.BookingStatusConverter;
import com.mm_cinema.campaign.model.Discount;
import com.mm_cinema.cinema.model.Cinema;
import com.mm_cinema.cinema.model.Movie;
import com.mm_cinema.cinema.model.ShowTime;
import com.mm_cinema.cinema.model.Theater;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import com.mm_cinema.customer.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private ShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Column(name = "booking_code", length = 255)
    private String bookingCode;

    @Column(name = "discount_code", length = 255)
    private String discountCode;

    @Column(length = 255)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "discount_amount")
    private Integer discountAmount = 0;

    @Column(name = "subtotal_amount")
    private Integer subtotalAmount = 0;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column
    private Integer type;

    @Convert(converter = BookingStatusConverter.class)
    @Column(name = "status")
    private BookingStatus status;

    @OneToMany(mappedBy = "booking")
    private List<BookingDetail> bookingDetails = new ArrayList<>();

    @OneToMany(mappedBy = "booking")
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "booking")
    private List<BookingActivityLog> bookingActivityLogs = new ArrayList<>();

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
