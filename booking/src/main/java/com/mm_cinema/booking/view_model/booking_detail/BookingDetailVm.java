package com.mm_cinema.booking.view_model.booking_detail;

import com.mm_cinema.booking.model.BookingDetail;

import java.time.LocalDateTime;

public record BookingDetailVm(
        Long id,
        Long bookingId,
        Long seatId,
        Long concessionId,
        String seatName,
        Integer quantity,
        LocalDateTime createdDate
) {
    public static BookingDetailVm fromModel(BookingDetail detail) {
        return new BookingDetailVm(
                detail.getId(),
                detail.getBooking() != null ? detail.getBooking().getId() : null,
                detail.getSeat() != null ? detail.getSeat().getId() : null,
                detail.getConcession() != null ? detail.getConcession().getId() : null,
                detail.getSeatName(),
                detail.getQuantity(),
                detail.getCreatedDate()
        );
    }
}