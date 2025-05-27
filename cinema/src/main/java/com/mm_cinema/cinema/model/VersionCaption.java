package com.mm_cinema.cinema.model;


import com.mm_cinema.common_library.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "version_captions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VersionCaption extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "showing_time_id", nullable = false)
    private ShowTime showingTime;

    @Column(name = "version_type", nullable = false)
    private Integer versionType;

    @Column(name = "caption_type", nullable = false)
    private Integer captionType;

    @Column(name = "screen_special_type", nullable = false)
    private Integer screenSpecialType;


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
