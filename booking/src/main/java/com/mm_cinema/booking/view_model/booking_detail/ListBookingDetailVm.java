package com.mm_cinema.booking.view_model.booking_detail;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.BookingDetail;

import java.util.List;
import java.util.stream.Collectors;

public record ListBookingDetailVm(List<BookingDetailVm> bookingDetails) {
    public static ListBookingDetailVm fromListEntity(List<BookingDetail> details) {
        List<BookingDetailVm> vmList = details.stream()
                .map(BookingDetailVm::fromModel)
                .collect(Collectors.toList());
        return new ListBookingDetailVm(vmList);
    }
}