package com.mm_cinema.cinema.view_model.ticket_type;

import com.mm_cinema.cinema.model.TicketType;

public record UpdateTicketTypeVm(
        Long id,
        String name,
        Integer price,
        Integer quantity,
        Integer quantityLock,
        Integer quantitySold,
        Integer minBookingPerTicket,
        Integer maxBookingPerTicket
) {
    public TicketType toTicketType() {
        return TicketType.builder()
                .id(id)
                .name(name)
                .price(price)
                .quantity(quantity)
                .quantityLock(quantityLock)
                .quantitySold(quantitySold)
                .minBookingPerTicket(minBookingPerTicket)
                .maxBookingPerTicket(maxBookingPerTicket)
                .build();
    }
}