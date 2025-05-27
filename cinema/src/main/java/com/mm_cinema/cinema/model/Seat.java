package com.mm_cinema.cinema.model;


import com.mm_cinema.cinema.model.enumeration.SeatStatus;
import com.mm_cinema.cinema.model.enumeration.SeatStatusConverter;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "momo_row_id", nullable = false)
    private Row row;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

    @Column(name = "area_code", length = 255)
    private String areaCode;

    @Column(name = "row_name", length = 255)
    private String rowName;

    @Column(name = "col_index", nullable = false)
    private Integer colIndex;

    @Column(name = "row_index", nullable = false)
    private Integer rowIndex;

    @Column(name = "momo_col_id", nullable = false)
    private Integer momoColId;

    @Column
    private Integer price = 0;

    @Convert(converter = SeatStatusConverter.class)
    @Column(nullable = false)
    private SeatStatus status;

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
