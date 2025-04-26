package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.city.CityVm;
import com.mm_cinema.cinema.view_model.city.UpdateCityVm;
import com.mm_cinema.cinema.view_model.ticket_type.TicketTypeVm;
import com.mm_cinema.cinema.view_model.ticket_type.UpdateTicketTypeVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ITicketTypeService {
    TicketTypeVm getTicketTypeDetail(Long id);
    void updateTicketType(UpdateTicketTypeVm ticketTypeVm);
    CollectionsResp getAllTicketTypes(Pageable pageable);
}