package com.mm_cinema.cinema.view_model.cinema;

import com.mm_cinema.cinema.model.Cinema;

import java.util.List;
import java.util.stream.Collectors;

public record ListCinemaVm(List<CinemaVm> cinemas) {
    public static ListCinemaVm fromListEntity(List<Cinema> cinemaEntities) {
        List<CinemaVm> cinemaVms = cinemaEntities.stream()
                .map(CinemaVm::fromModel)
                .collect(Collectors.toList());
        return new ListCinemaVm(cinemaVms);
    }
}