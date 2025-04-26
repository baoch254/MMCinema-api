package com.mm_cinema.booking.view_model.booking;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.enumeration.BookingStatus;

import java.time.LocalDateTime;

public record BookingVm(
        Long id,
        Long cinemaId,
        Long theaterId,
        Long showTimeId,
        Long movieId,
        Long customerId,
        Long discountId,
        String bookingCode,
        String email,
        Integer totalAmount,
        BookingStatus status,
        LocalDateTime createdDate
) {
    public static BookingVm fromModel(Booking booking) {
        return new BookingVm(
                booking.getId(),
                booking.getCinema() != null ? booking.getCinema().getId() : null,
                booking.getTheater() != null ? booking.getTheater().getId() : null,
                booking.getShowTime() != null ? booking.getShowTime().getId() : null,
                booking.getMovie() != null ? booking.getMovie().getId() : null,
                booking.getCustomer() != null ? booking.getCustomer().getId() : null,
                booking.getDiscount() != null ? booking.getDiscount().getId() : null,
                booking.getBookingCode(),
                booking.getEmail(),
                booking.getTotalAmount(),
                booking.getStatus(),
                booking.getCreatedDate()
        );
    }
}