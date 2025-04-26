package com.mm_cinema.cinema.view_model.theater;

import com.mm_cinema.cinema.model.Theater;

import java.time.LocalDateTime;

public record TheaterVm(
        Long id,
        Long cinemaId,
        String name,
        Integer totalSeats,
        Integer status,
        LocalDateTime createdDate
) {
    public static TheaterVm fromModel(Theater theater) {
        return new TheaterVm(
                theater.getId(),
                theater.getCinema().getId(),
                theater.getName(),
                theater.getTotalSeats(),
                theater.getStatus(),
                theater.getCreatedDate()
        );
    }
}