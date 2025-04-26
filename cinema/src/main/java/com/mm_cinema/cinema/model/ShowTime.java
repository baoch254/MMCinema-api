package com.mm_cinema.cinema.model;


import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "showtimes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowTime extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_cinema_id", nullable = false)
    private Integer apiCinemaId;

    @Column(name = "api_film_id", nullable = false)
    private Integer apiFilmId;

    @Column(name = "show_time", nullable = false)
    private LocalDateTime showTime;

    @Column(nullable = false)
    private Integer duration;

    @Column(name = "show_time_duration", length = 100)
    private String showTimeDuration;

    @Column(name = "screen_name", length = 100)
    private String screenName;

    @Column(name = "show_time_link", length = 255)
    private String showTimeLink;

    @OneToMany(mappedBy = "showingTime")
    private List<VersionCaption> versionCaptions = new ArrayList<>();

    @OneToMany(mappedBy = "showTime")
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
