package com.mm_cinema.cinema.view_model.cineplex;

import com.mm_cinema.cinema.model.Cineplex;

import java.util.List;
import java.util.stream.Collectors;

public record ListCineplexVm(List<CineplexVm> cineplexes) {
    public static ListCineplexVm fromListEntity(List<Cineplex> cineplexEntities) {
        List<CineplexVm> cineplexVms = cineplexEntities.stream()
                .map(CineplexVm::fromModel)
                .collect(Collectors.toList());
        return new ListCineplexVm(cineplexVms);
    }
}