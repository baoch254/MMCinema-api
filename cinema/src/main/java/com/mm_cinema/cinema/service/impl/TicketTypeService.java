package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.*;
import com.mm_cinema.cinema.repository.*;
import com.mm_cinema.cinema.service.*;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.*;
import com.mm_cinema.cinema.view_model.ticket_type.TicketTypeVm;
import com.mm_cinema.cinema.view_model.ticket_type.UpdateTicketTypeVm;
import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class TicketTypeService implements ITicketTypeService {
    private final TicketTypeRepository ticketTypeRepository;

    public TicketTypeService(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    @Override
    public TicketTypeVm getTicketTypeDetail(Long id) {
        TicketType entity = ticketTypeRepository.findById(id).orElse(new TicketType());
        return TicketTypeVm.fromModel(entity);
    }

    @Override
    public void updateTicketType(UpdateTicketTypeVm vm) {
        TicketType entity = getTicketTypeById(vm.id());
        ticketTypeRepository.save(entity);
    }

    @Override
    public CollectionsResp getAllTicketTypes(Pageable pageable) {
        Page<TicketType> page = ticketTypeRepository.findAll(pageable);
        List<TicketTypeVm> vms = page.getContent().stream().map(TicketTypeVm::fromModel).collect(Collectors.toList());
        return new CollectionsResp(vms, new Pagination(page));
    }

    private TicketType getTicketTypeById(long id) {
        return ticketTypeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.TICKET_TYPE_NOT_FOUND, id));
    }
}
