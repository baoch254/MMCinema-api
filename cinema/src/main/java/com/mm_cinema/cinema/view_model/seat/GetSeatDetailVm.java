package com.mm_cinema.cinema.view_model.seat;

import com.mm_cinema.cinema.model.Seat;
import com.mm_cinema.cinema.model.enumeration.SeatStatus;

import java.time.LocalDateTime;

public record GetSeatDetailVm(
        Long id,
        Long rowId,
        Long ticketTypeId,
        String areaCode,
        String rowName,
        Integer colIndex,
        Integer rowIndex,
        Integer momoColId,
        Integer price,
        SeatStatus status,
        LocalDateTime createdDate
) {
    public static GetSeatDetailVm fromModel(Seat seat) {
        return new GetSeatDetailVm(
                seat.getId(),
                seat.getRow().getId(),
                seat.getTicketType() != null ? seat.getTicketType().getId() : null,
                seat.getAreaCode(),
                seat.getRowName(),
                seat.getColIndex(),
                seat.getRowIndex(),
                seat.getMomoColId(),
                seat.getPrice(),
                seat.getStatus(),
                seat.getCreatedDate()
        );
    }
}