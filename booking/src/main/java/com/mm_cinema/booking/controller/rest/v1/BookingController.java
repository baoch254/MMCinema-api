package com.mm_cinema.booking.controller.rest.v1;

import com.mm_cinema.booking.service.impl.BookingService;
import com.mm_cinema.booking.view_model.booking.BookingVm;
import com.mm_cinema.booking.view_model.booking.UpdateBookingVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingDetail(@PathVariable Long id) {
        BookingVm booking = bookingService.getBookingDetail(id);
        return ResponseUtil.successWithData(booking, "Booking retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateBooking(@Valid @RequestBody UpdateBookingVm bookingVm) {
        bookingService.updateBooking(bookingVm);
        return ResponseUtil.success("Booking updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllBookings(Pageable pageable) {
        CollectionsResp bookings = bookingService.getAllBookings(pageable);
        return ResponseUtil.successWithCollection(bookings);
    }
}