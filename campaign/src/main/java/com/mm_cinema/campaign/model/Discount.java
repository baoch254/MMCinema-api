package com.mm_cinema.campaign.model;


import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.campaign.model.enumeration.DiscountStatus;
import com.mm_cinema.campaign.model.enumeration.DiscountStatusConverter;
import com.mm_cinema.campaign.model.enumeration.PromotionStatus;
import com.mm_cinema.campaign.model.enumeration.PromotionStatusConverter;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Discount extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @Column(nullable = false)
    private Integer type; // percentage, fixed_amount

    @Column(precision = 10, scale = 2)
    private BigDecimal value;

    @Column(length = 50)
    private String code;

    @Column
    private Integer quantity = 0;

    @Convert(converter = DiscountStatusConverter.class)
    @Column(name = "status")
    private DiscountStatus status;

    @OneToMany(mappedBy = "discount")
    private List<DiscountRule> discountRules = new ArrayList<>();

    @OneToMany(mappedBy = "discount")
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
