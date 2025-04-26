package com.mm_cinema.booking.controller.rest.v1;

import com.mm_cinema.booking.service.impl.BookingDetailService;
import com.mm_cinema.booking.view_model.booking_detail.BookingDetailVm;
import com.mm_cinema.booking.view_model.booking_detail.UpdateBookingDetailVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-details")
public class BookingDetailController {
    private final BookingDetailService bookingDetailService;

    public BookingDetailController(BookingDetailService bookingDetailService) {
        this.bookingDetailService = bookingDetailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingDetail(@PathVariable Long id) {
        BookingDetailVm bookingDetail = bookingDetailService.getBookingDetailDetail(id);
        return ResponseUtil.successWithData(bookingDetail, "Booking Detail retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateBookingDetail(@Valid @RequestBody UpdateBookingDetailVm bookingDetailVm) {
        bookingDetailService.updateBookingDetail(bookingDetailVm);
        return ResponseUtil.success("Booking Detail updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllBookingDetails(Pageable pageable) {
        CollectionsResp bookingDetails = bookingDetailService.getAllBookingDetails(pageable);
        return ResponseUtil.successWithCollection(bookingDetails);
    }
}