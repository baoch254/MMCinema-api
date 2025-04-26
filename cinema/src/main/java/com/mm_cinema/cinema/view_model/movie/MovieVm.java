package com.mm_cinema.cinema.view_model.movie;

import com.mm_cinema.cinema.model.Movie;

import java.time.LocalDateTime;

public record MovieVm(
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
        LocalDateTime startTime,
        LocalDateTime createdDate
) {
    public static MovieVm fromModel(Movie movie) {
        return new MovieVm(
                movie.getId(),
                movie.getTitle(),
                movie.getTitleEn(),
                movie.getSynopsis(),
                movie.getSynopsisEn(),
                movie.getImageUrl(),
                movie.getDescription(),
                movie.getDescriptionEn(),
                movie.getDurationMinutes(),
                movie.getBannerUrl(),
                movie.getGraphicUrl(),
                movie.getApiSneakShowDate(),
                movie.getApiAutoPlayTrailer(),
                movie.getApiAverageScore(),
                movie.getApiFilmType(),
                movie.getApiGenreName(),
                movie.getApiRating(),
                movie.getApiRatingFormat(),
                movie.getOpeningDate(),
                movie.getShortName(),
                movie.getTrailerUrl(),
                movie.getLink(),
                movie.getStartTime(),
                movie.getCreatedDate()
        );
    }
}