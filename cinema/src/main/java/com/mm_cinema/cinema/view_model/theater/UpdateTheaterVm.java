package com.mm_cinema.cinema.view_model.theater;

import com.mm_cinema.cinema.model.Cinema;
import com.mm_cinema.cinema.model.Theater;

public record UpdateTheaterVm(
        Long id,
        Long cinemaId,
        String name,
        Integer totalSeats,
        Integer status
) {
    public Theater toTheater() {
        return Theater.builder()
                .id(id)
                .cinema(new Cinema())
                .name(name)
                .totalSeats(totalSeats)
                .status(status)
                .build();
    }
}