package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.TicketTypeService;
import com.mm_cinema.cinema.view_model.ticket_type.TicketTypeVm;
import com.mm_cinema.cinema.view_model.ticket_type.UpdateTicketTypeVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickettypes")
public class TicketTypeController {
    private final TicketTypeService ticketTypeService;

    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketTypeDetail(@PathVariable Long id) {
        TicketTypeVm ticketType = ticketTypeService.getTicketTypeDetail(id);
        return ResponseUtil.successWithData(ticketType, "TicketType retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateTicketType(@Valid @RequestBody UpdateTicketTypeVm ticketTypeVm) {
        ticketTypeService.updateTicketType(ticketTypeVm);
        return ResponseUtil.success("TicketType updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTicketTypes(Pageable pageable) {
        CollectionsResp ticketTypes = ticketTypeService.getAllTicketTypes(pageable);
        return ResponseUtil.successWithCollection(ticketTypes);
    }
}