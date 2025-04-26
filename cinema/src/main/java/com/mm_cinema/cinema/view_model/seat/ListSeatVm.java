package com.mm_cinema.cinema.view_model.seat;

import com.mm_cinema.cinema.model.Movie;
import com.mm_cinema.cinema.model.Seat;

import java.util.List;
import java.util.stream.Collectors;

public record ListSeatVm(List<SeatVm> seats) {
    public static ListSeatVm fromListEntity(List<Seat> seatEntities) {
        List<SeatVm> seatVms = seatEntities.stream()
                .map(SeatVm::fromModel)
                .collect(Collectors.toList());
        return new ListSeatVm(seatVms);
    }
}