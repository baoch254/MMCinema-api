package com.mm_cinema.booking.service.impl;

import com.mm_cinema.booking.model.Concession;
import com.mm_cinema.booking.repository.ConcessionRepository;
import com.mm_cinema.booking.service.IConcessionService;
import com.mm_cinema.booking.utils.Constants;
import com.mm_cinema.booking.view_model.concession.ConcessionVm;
import com.mm_cinema.booking.view_model.concession.UpdateConcessionVm;
import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConcessionService implements IConcessionService {

    private final ConcessionRepository concessionRepository;

    public ConcessionService(ConcessionRepository concessionRepository) {
        this.concessionRepository = concessionRepository;
    }

    @Override
    public ConcessionVm getConcessionDetail(Long id) {
        Concession concession = concessionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.CONCESSION_NOT_FOUND, id));
        return ConcessionVm.fromModel(concession);
    }

    @Override
    public void updateConcession(UpdateConcessionVm concessionVm) {
        Concession concession = concessionRepository.findById(concessionVm.id())
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.CONCESSION_NOT_FOUND, concessionVm.id()));
        // Update fields here and save
        concessionRepository.save(concession);
    }

    @Override
    public CollectionsResp getAllConcessions(Pageable pageable) {
        Page<Concession> concessionPage = concessionRepository.findAll(pageable);
        List<ConcessionVm> concessionVms = concessionPage.getContent().stream()
                .map(ConcessionVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                concessionPage.getTotalElements(),
                concessionPage.getTotalPages(),
                concessionPage.getSize(),
                concessionPage.getNumber() + 1
        );

        return new CollectionsResp(concessionVms, pagination);
    }
}