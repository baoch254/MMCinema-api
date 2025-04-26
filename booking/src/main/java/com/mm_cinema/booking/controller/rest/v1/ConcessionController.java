package com.mm_cinema.booking.controller.rest.v1;

import com.mm_cinema.booking.service.impl.ConcessionService;
import com.mm_cinema.booking.view_model.concession.ConcessionVm;
import com.mm_cinema.booking.view_model.concession.UpdateConcessionVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concessions")
public class ConcessionController {
    private final ConcessionService concessionService;

    public ConcessionController(ConcessionService concessionService) {
        this.concessionService = concessionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConcessionDetail(@PathVariable Long id) {
        ConcessionVm concession = concessionService.getConcessionDetail(id);
        return ResponseUtil.successWithData(concession, "Concession retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateConcession(@Valid @RequestBody UpdateConcessionVm concessionVm) {
        concessionService.updateConcession(concessionVm);
        return ResponseUtil.success("Concession updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllConcessions(Pageable pageable) {
        CollectionsResp concessions = concessionService.getAllConcessions(pageable);
        return ResponseUtil.successWithCollection(concessions);
    }
}