package com.mm_cinema.booking.service.impl;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.repository.BookingRepository;
import com.mm_cinema.booking.service.IBookingService;
import com.mm_cinema.booking.utils.Constants;
import com.mm_cinema.booking.view_model.booking.BookingVm;
import com.mm_cinema.booking.view_model.booking.UpdateBookingVm;
import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingVm getBookingDetail(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.BOOKING_NOT_FOUND, id));
        return BookingVm.fromModel(booking);
    }

    @Override
    public void updateBooking(UpdateBookingVm bookingVm) {
        Booking booking = bookingRepository.findById(bookingVm.id()).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.BOOKING_NOT_FOUND, bookingVm.id()));
        // Update the necessary fields and save
        bookingRepository.save(booking);
    }

    @Override
    public CollectionsResp getAllBookings(Pageable pageable) {
        Page<Booking> bookingPage = bookingRepository.findAll(pageable);
        List<BookingVm> bookingVms = bookingPage.getContent().stream()
                .map(BookingVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                bookingPage.getTotalElements(),
                bookingPage.getTotalPages(),
                bookingPage.getSize(),
                bookingPage.getNumber() + 1
        );

        return new CollectionsResp(bookingVms, pagination);
    }

    @Override
    public void updateStatusById(Long id, int status) {
        bookingRepository.updateStatusById(id, status);
    }
}