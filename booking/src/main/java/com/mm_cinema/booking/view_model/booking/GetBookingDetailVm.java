package com.mm_cinema.booking.view_model.booking;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.enumeration.BookingStatus;

import java.time.LocalDateTime;

public record GetBookingDetailVm(
        Long id,
        Long cinemaId,
        Long theaterId,
        Long showTimeId,
        Long movieId,
        Long customerId,
        Long discountId,
        String bookingCode,
        String discountCode,
        String email,
        String phoneNumber,
        String paymentMethod,
        Integer discountAmount,
        Integer subtotalAmount,
        Integer totalAmount,
        Integer type,
        BookingStatus status,
        LocalDateTime createdDate
) {
    public static GetBookingDetailVm fromModel(Booking booking) {
        return new GetBookingDetailVm(
                booking.getId(),
                booking.getCinema() != null ? booking.getCinema().getId() : null,
                booking.getTheater() != null ? booking.getTheater().getId() : null,
                booking.getShowTime() != null ? booking.getShowTime().getId() : null,
                booking.getMovie() != null ? booking.getMovie().getId() : null,
                booking.getCustomer() != null ? booking.getCustomer().getId() : null,
                booking.getDiscount() != null ? booking.getDiscount().getId() : null,
                booking.getBookingCode(),
                booking.getDiscountCode(),
                booking.getEmail(),
                booking.getPhoneNumber(),
                booking.getPaymentMethod(),
                booking.getDiscountAmount(),
                booking.getSubtotalAmount(),
                booking.getTotalAmount(),
                booking.getType(),
                booking.getStatus(),
                booking.getCreatedDate()
        );
    }
}