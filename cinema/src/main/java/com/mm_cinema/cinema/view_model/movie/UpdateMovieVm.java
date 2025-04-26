package com.mm_cinema.cinema.view_model.movie;

import com.mm_cinema.cinema.model.Movie;

import java.time.LocalDateTime;

public record UpdateMovieVm(
        Long id,
        String title,
        String titleEn,
        String synopsis,
        String synopsisEn,
        String imageUrl,
        String description,
        String descriptionEn,
        Integer durationMinutes,
        String bannerUrl,
        String graphicUrl,
        LocalDateTime apiSneakShowDate,
        String apiAutoPlayTrailer,
        Float apiAverageScore,
        String apiFilmType,
        String apiGenreName,
        String apiRating,
        String apiRatingFormat,
        LocalDateTime openingDate,
        String shortName,
        String trailerUrl,
        String link,
        LocalDateTime startTime
) {
    public Movie toMovie() {
        return Movie.builder()
                .id(id)
                .title(title)
                .titleEn(titleEn)
                .synopsis(synopsis)
                .synopsisEn(synopsisEn)
                .imageUrl(imageUrl)
                .description(description)
                .descriptionEn(descriptionEn)
                .durationMinutes(durationMinutes)
                .bannerUrl(bannerUrl)
                .graphicUrl(graphicUrl)
                .apiSneakShowDate(apiSneakShowDate)
                .apiAutoPlayTrailer(apiAutoPlayTrailer)
                .apiAverageScore(apiAverageScore)
                .apiFilmType(apiFilmType)
                .apiGenreName(apiGenreName)
                .apiRating(apiRating)
                .apiRatingFormat(apiRatingFormat)
                .openingDate(openingDate)
                .shortName(shortName)
                .trailerUrl(trailerUrl)
                .link(link)
                .startTime(startTime)
                .build();
    }
}