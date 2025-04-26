package com.mm_cinema.booking.model;


import com.mm_cinema.booking.model.enumeration.TransactionStatus;
import com.mm_cinema.booking.model.enumeration.TransactionStatusConverter;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(name = "transaction_id", length = 64)
    private String transactionId;

    @Column
    private Integer amount = 0;

    @Column(name = "partner_name", length = 50)
    private String partnerName;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Convert(converter = TransactionStatusConverter.class)
    @Column(name = "status")
    private TransactionStatus status;

    @Column(length = 255)
    private String message;

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
