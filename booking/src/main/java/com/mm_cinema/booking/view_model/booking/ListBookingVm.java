package com.mm_cinema.booking.view_model.booking;

import com.mm_cinema.booking.model.Booking;

import java.util.List;
import java.util.stream.Collectors;

public record ListBookingVm(List<BookingVm> bookings) {
    public static ListBookingVm fromListEntity(List<Booking> bookingEntities) {
        List<BookingVm> vmList = bookingEntities.stream()
                .map(BookingVm::fromModel)
                .collect(Collectors.toList());
        return new ListBookingVm(vmList);
    }
}