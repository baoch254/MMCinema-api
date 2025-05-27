package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.*;
import com.mm_cinema.cinema.repository.*;
import com.mm_cinema.cinema.service.*;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.seat.SeatVm;
import com.mm_cinema.cinema.view_model.seat.UpdateSeatVm;
import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class SeatService implements ISeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public SeatVm getSeatDetail(Long id) {
        Seat seat = seatRepository.findById(id).orElse(new Seat());
        return SeatVm.fromModel(seat);
    }

    @Override
    public void updateSeat(UpdateSeatVm seatVm) {
        Seat seat = getSeatById(seatVm.id());
        seatRepository.save(seat);
    }

    @Override
    public CollectionsResp getAllSeats(Pageable pageable) {
        Page<Seat> page = seatRepository.findAll(pageable);
        List<SeatVm> vms = page.getContent().stream().map(SeatVm::fromModel).collect(Collectors.toList());
        return new CollectionsResp(vms, new Pagination(page));
    }

    @Override
    public void updateStatusById(Long id, int status) {
        seatRepository.updateStatusById(id, status);
    }

    private Seat getSeatById(long id) {
        return seatRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.SEAT_NOT_FOUND, id));
    }
}
