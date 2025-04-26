package com.mm_cinema.booking.view_model.booking;


import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.enumeration.BookingStatus;

public record UpdateBookingVm(
        Long id,
        Long cinemaId,
        Long theaterId,
        Long showTimeId,
        Long movieId,
        Long customerId,
        Long discountId,
        String email,
        String phoneNumber,
        String paymentMethod,
        Integer discountAmount,
        Integer subtotalAmount,
        Integer totalAmount,
        Integer type,
        BookingStatus status
) {
    public Booking toBooking() {
        Booking booking = new Booking();
        booking.setId(id);
        booking.setEmail(email);
        booking.setPhoneNumber(phoneNumber);
        booking.setPaymentMethod(paymentMethod);
        booking.setDiscountAmount(discountAmount);
        booking.setSubtotalAmount(subtotalAmount);
        booking.setTotalAmount(totalAmount);
        booking.setType(type);
        booking.setStatus(status);
        return booking;
    }
}