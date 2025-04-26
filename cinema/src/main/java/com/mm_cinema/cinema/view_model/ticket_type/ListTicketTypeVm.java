package com.mm_cinema.cinema.view_model.ticket_type;

import com.mm_cinema.cinema.model.TicketType;

import java.util.List;
import java.util.stream.Collectors;

public record ListTicketTypeVm(List<TicketTypeVm> ticketTypes) {
    public static ListTicketTypeVm fromListEntity(List<TicketType> ticketTypeEntities) {
        List<TicketTypeVm> ticketTypeVms = ticketTypeEntities.stream()
                .map(TicketTypeVm::fromModel)
                .collect(Collectors.toList());
        return new ListTicketTypeVm(ticketTypeVms);
    }
}