package com.mm_cinema.cinema.view_model.theater;

import com.mm_cinema.cinema.model.Theater;

import java.util.List;
import java.util.stream.Collectors;

public record ListTheaterVm(List<TheaterVm> theaters) {
    public static ListTheaterVm fromListEntity(List<Theater> theaterEntities) {
        List<TheaterVm> theaterVms = theaterEntities.stream()
                .map(TheaterVm::fromModel)
                .collect(Collectors.toList());
        return new ListTheaterVm(theaterVms);
    }
}