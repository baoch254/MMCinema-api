package com.mm_cinema.cinema.view_model.cineplex;

import com.mm_cinema.cinema.model.Cineplex;

import java.time.LocalDateTime;

public record GetCineplexDetailVm(
        Long id,
        String name,
        String code,
        String avatar,
        String logo,
        LocalDateTime createdDate
) {
    public static GetCineplexDetailVm fromModel(Cineplex cineplex) {
        return new GetCineplexDetailVm(
                cineplex.getId(),
                cineplex.getName(),
                cineplex.getCode(),
                cineplex.getAvatar(),
                cineplex.getLogo(),
                cineplex.getCreatedDate()
        );
    }
}