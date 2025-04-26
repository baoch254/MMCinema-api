package com.mm_cinema.booking.service.impl;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.BookingDetail;
import com.mm_cinema.booking.repository.BookingDetailRepository;
import com.mm_cinema.booking.service.IBookingDetailService;
import com.mm_cinema.booking.utils.Constants;
import com.mm_cinema.booking.view_model.booking.UpdateBookingVm;
import com.mm_cinema.booking.view_model.booking_detail.BookingDetailVm;
import com.mm_cinema.booking.view_model.booking_detail.UpdateBookingDetailVm;
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
public class BookingDetailService implements IBookingDetailService {

    private final BookingDetailRepository bookingDetailRepository;

    public BookingDetailService(BookingDetailRepository bookingDetailRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
    }

    @Override
    public BookingDetailVm getBookingDetailDetail(Long id) {
        BookingDetail detail = bookingDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.BOOKING_DETAIL_NOT_FOUND, id));
        return BookingDetailVm.fromModel(detail);
    }

    @Override
    public void updateBookingDetail(UpdateBookingDetailVm updateBookingVm) {
        BookingDetail bookingDetail = bookingDetailRepository.findById(updateBookingVm.id()).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.BOOKING_DETAIL_NOT_FOUND, updateBookingVm.id()));
        // Update the necessary fields and save
        bookingDetailRepository.save(bookingDetail);
    }

    @Override
    public CollectionsResp getAllBookingDetails(Pageable pageable) {
        Page<BookingDetail> detailPage = bookingDetailRepository.findAll(pageable);
        List<BookingDetailVm> detailVms = detailPage.getContent().stream()
                .map(BookingDetailVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                detailPage.getTotalElements(),
                detailPage.getTotalPages(),
                detailPage.getSize(),
                detailPage.getNumber() + 1
        );

        return new CollectionsResp(detailVms, pagination);
    }
}