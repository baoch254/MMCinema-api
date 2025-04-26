package com.mm_cinema.cinema.model;


import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "title_en", nullable = false, length = 255)
    private String titleEn;

    @Column(nullable = false, length = 255)
    private String synopsis;

    @Column(name = "synopsis_en", nullable = false, length = 255)
    private String synopsisEn;

    @Column(name = "image_url", nullable = false, length = 255)
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "description_en", columnDefinition = "TEXT")
    private String descriptionEn;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "banner_url", length = 255)
    private String bannerUrl;

    @Column(name = "graphic_url", length = 255)
    private String graphicUrl;

    @Column(name = "api_sneak_show_date")
    private LocalDateTime apiSneakShowDate;

    @Column(name = "api_auto_play_trailer", length = 255)
    private String apiAutoPlayTrailer;

    @Column(name = "api_average_score")
    private Float apiAverageScore = 0.0f;

    @Column(name = "api_film_type", length = 255)
    private String apiFilmType;

    @Column(name = "api_genre_name", length = 255)
    private String apiGenreName;

    @Column(name = "api_rating", length = 20)
    private String apiRating;

    @Column(name = "api_rating_format", length = 20)
    private String apiRatingFormat;

    @Column(name = "opening_date")
    private LocalDateTime openingDate;

    @Column(name = "short_name", length = 255)
    private String shortName;

    @Column(name = "trailer_url", length = 255)
    private String trailerUrl;

    @Column(length = 255)
    private String link;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @OneToMany(mappedBy = "movie")
    private List<VersionCaption> versionCaptions = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
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
