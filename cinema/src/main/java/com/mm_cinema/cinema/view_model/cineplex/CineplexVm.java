package com.mm_cinema.cinema.view_model.cineplex;

import com.mm_cinema.cinema.model.Cineplex;

import java.time.LocalDateTime;

public record CineplexVm(
        Long id,
        String name,
        String code,
        String avatar,
        String logo,
        LocalDateTime createdDate
) {
    public static CineplexVm fromModel(Cineplex cineplex) {
        return new CineplexVm(
                cineplex.getId(),
                cineplex.getName(),
                cineplex.getCode(),
                cineplex.getAvatar(),
                cineplex.getLogo(),
                cineplex.getCreatedDate()
        );
    }
}