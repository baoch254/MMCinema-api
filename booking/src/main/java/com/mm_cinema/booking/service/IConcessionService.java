package com.mm_cinema.booking.service;

import com.mm_cinema.booking.view_model.concession.ConcessionVm;
import com.mm_cinema.booking.view_model.concession.UpdateConcessionVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface IConcessionService {
    ConcessionVm getConcessionDetail(Long id);
    void updateConcession(UpdateConcessionVm concessionVm);
    CollectionsResp getAllConcessions(Pageable pageable);
}