package com.mm_cinema.booking.view_model.booking_detail;


import com.mm_cinema.booking.model.BookingDetail;

public record UpdateBookingDetailVm(
        Long id,
        Long bookingId,
        Long seatId,
        Long concessionId,
        String seatName,
        Integer quantity
) {
    public BookingDetail toEntity() {
        BookingDetail detail = new BookingDetail();
        detail.setId(id);
        detail.setSeatName(seatName);
        detail.setQuantity(quantity);
        return detail;
    }
}