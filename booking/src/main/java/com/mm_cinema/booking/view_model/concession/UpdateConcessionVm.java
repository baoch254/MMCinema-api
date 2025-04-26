package com.mm_cinema.booking.view_model.concession;


import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.Concession;
import com.mm_cinema.booking.model.enumeration.BookingStatus;

public record UpdateConcessionVm(
        Long id,
        Long categoryId,
        String name,
        Integer price,
        Integer quantity,
        String description,
        String descriptionAlt,
        String thumbnail
) {
    public Concession toEntity() {
        Concession concession = new Concession();
        concession.setId(id);
        concession.setName(name);
        concession.setPrice(price);
        concession.setQuantity(quantity);
        concession.setDescription(description);
        concession.setDescriptionAlt(descriptionAlt);
        concession.setThumbnail(thumbnail);
        return concession;
    }
}