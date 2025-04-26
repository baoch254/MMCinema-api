package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.ISeatService;
import com.mm_cinema.cinema.service.impl.SeatService;
import com.mm_cinema.cinema.view_model.seat.SeatVm;
import com.mm_cinema.cinema.view_model.seat.UpdateSeatVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeatDetail(@PathVariable Long id) {
        SeatVm seat = seatService.getSeatDetail(id);
        return ResponseUtil.successWithData(seat, "Seat retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateSeat(@Valid @RequestBody UpdateSeatVm seatVm) {
        seatService.updateSeat(seatVm);
        return ResponseUtil.success("Seat updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllSeats(Pageable pageable) {
        CollectionsResp seats = seatService.getAllSeats(pageable);
        return ResponseUtil.successWithCollection(seats);
    }
}