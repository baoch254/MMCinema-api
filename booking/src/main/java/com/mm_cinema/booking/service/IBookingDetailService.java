package com.mm_cinema.booking.service;

import com.mm_cinema.booking.view_model.booking.UpdateBookingVm;
import com.mm_cinema.booking.view_model.booking_detail.BookingDetailVm;
import com.mm_cinema.booking.view_model.booking_detail.UpdateBookingDetailVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface IBookingDetailService {
    BookingDetailVm getBookingDetailDetail(Long id);
    void updateBookingDetail(UpdateBookingDetailVm updateBookingVm);
    CollectionsResp getAllBookingDetails(Pageable pageable);
}