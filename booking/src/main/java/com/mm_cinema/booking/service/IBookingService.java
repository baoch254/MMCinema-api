package com.mm_cinema.booking.service;

import com.mm_cinema.booking.view_model.booking.BookingVm;
import com.mm_cinema.booking.view_model.booking.UpdateBookingVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface IBookingService {
    BookingVm getBookingDetail(Long id);
    void updateBooking(UpdateBookingVm bookingVm);
    CollectionsResp getAllBookings(Pageable pageable);

    void updateStatusById(Long id, int status);
}