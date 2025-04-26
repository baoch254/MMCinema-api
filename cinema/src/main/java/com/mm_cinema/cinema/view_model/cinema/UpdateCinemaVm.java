package com.mm_cinema.cinema.view_model.cinema;

import com.mm_cinema.cinema.model.Cinema;

public record UpdateCinemaVm(
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
        String urlRewrite
) {
    public Cinema toCinema() {
        return Cinema.builder()
                .id(id)
                .name(name)
                .apiCinemaId(apiCinemaId)
                .cityName(cityName)
                .address(address)
                .avatar(avatar)
                .logo(logo)
                .cineplexFeaturedNote(cineplexFeaturedNote)
                .description(description)
                .displayOrder(displayOrder)
                .featuredNote(featuredNote)
                .indexMark(indexMark)
                .isOrderLink(isOrderLink)
                .lat(lat)
                .lon(lon)
                .ratingCount(ratingCount)
                .ratingValue(ratingValue)
                .shortName(shortName)
                .urlRewrite(urlRewrite)
                .build();
    }
}