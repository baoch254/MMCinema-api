package com.mm_cinema.cinema.view_model.cinema;

import com.mm_cinema.cinema.model.Cinema;

import java.time.LocalDateTime;

public record CinemaVm(
        Long id,
        String name,
        String apiCinemaId,
        String cityName,
        String address,
        String avatar,
        String logo,
        String cineplexFeaturedNote,
        String description,
        Integer displayOrder,
        String featuredNote,
        Integer indexMark,
        Boolean isOrderLink,
        Float lat,
        Float lon,
        Integer ratingCount,
        Float ratingValue,
        String shortName,
        String urlRewrite,
        LocalDateTime createdDate
) {
    public static CinemaVm fromModel(Cinema cinema) {
        return new CinemaVm(
                cinema.getId(),
                cinema.getName(),
                cinema.getApiCinemaId(),
                cinema.getCityName(),
                cinema.getAddress(),
                cinema.getAvatar(),
                cinema.getLogo(),
                cinema.getCineplexFeaturedNote(),
                cinema.getDescription(),
                cinema.getDisplayOrder(),
                cinema.getFeaturedNote(),
                cinema.getIndexMark(),
                cinema.getIsOrderLink(),
                cinema.getLat(),
                cinema.getLon(),
                cinema.getRatingCount(),
                cinema.getRatingValue(),
                cinema.getShortName(),
                cinema.getUrlRewrite(),
                cinema.getCreatedDate()
        );
    }
}
