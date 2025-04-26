package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.seat.SeatVm;
import com.mm_cinema.cinema.view_model.seat.UpdateSeatVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ISeatService {
    SeatVm getSeatDetail(Long id);

    void updateSeat(UpdateSeatVm seatVm);

    CollectionsResp getAllSeats(Pageable pageable);

    void updateStatusById(Long id, int status);
}