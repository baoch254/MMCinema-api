package com.mm_cinema.cinema.view_model.seat;

import com.mm_cinema.cinema.model.Row;
import com.mm_cinema.cinema.model.Seat;
import com.mm_cinema.cinema.model.TicketType;
import com.mm_cinema.cinema.model.enumeration.SeatStatus;

public record UpdateSeatVm(
        Long id,
        Long rowId,
        Long ticketTypeId,
        String areaCode,
        String rowName,
        Integer colIndex,
        Integer rowIndex,
        Integer momoColId,
        Integer price,
        SeatStatus status
) {
    public Seat toSeat() {
        return Seat.builder()
                .id(id)
                .row(new Row())
                .ticketType(ticketTypeId != null ? new TicketType() : null)
                .areaCode(areaCode)
                .rowName(rowName)
                .colIndex(colIndex)
                .rowIndex(rowIndex)
                .momoColId(momoColId)
                .price(price)
                .status(status)
                .build();
    }
}