package com.mm_cinema.booking.view_model.concession;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.Concession;
import com.mm_cinema.booking.model.enumeration.BookingStatus;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

public record ConcessionVm(
        Long id,
        Long categoryId,
        String name,
        Integer price,
        Integer quantity,
        String description,
        String descriptionAlt,
        String thumbnail,
        LocalDateTime createdDate
) {
    public static ConcessionVm fromModel(Concession concession) {
        return new ConcessionVm(
                concession.getId(),
                concession.getCategory() != null ? concession.getCategory().getId() : null,
                concession.getName(),
                concession.getPrice(),
                concession.getQuantity(),
                concession.getDescription(),
                concession.getDescriptionAlt(),
                concession.getThumbnail(),
                concession.getCreatedDate()
        );
    }
}