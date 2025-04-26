package com.mm_cinema.cinema.view_model.ticket_type;

import com.mm_cinema.cinema.model.TicketType;

import java.time.LocalDateTime;

public record TicketTypeVm(
        Long id,
        String name,
        Integer price,
        Integer quantity,
        Integer quantityLock,
        Integer quantitySold,
        Integer minBookingPerTicket,
        Integer maxBookingPerTicket,
        LocalDateTime createdDate
) {
    public static TicketTypeVm fromModel(TicketType ticketType) {
        return new TicketTypeVm(
                ticketType.getId(),
                ticketType.getName(),
                ticketType.getPrice(),
                ticketType.getQuantity(),
                ticketType.getQuantityLock(),
                ticketType.getQuantitySold(),
                ticketType.getMinBookingPerTicket(),
                ticketType.getMaxBookingPerTicket(),
                ticketType.getCreatedDate()
        );
    }
}