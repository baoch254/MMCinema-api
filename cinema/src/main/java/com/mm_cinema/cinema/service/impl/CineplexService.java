package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.Cineplex;
import com.mm_cinema.cinema.repository.CineplexRepository;
import com.mm_cinema.cinema.service.ICineplexService;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.cineplex.CineplexVm;
import com.mm_cinema.cinema.view_model.cineplex.UpdateCineplexVm;
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
public class CineplexService implements ICineplexService {

    private final CineplexRepository cineplexRepository;

    public CineplexService(CineplexRepository cineplexRepository) {
        this.cineplexRepository = cineplexRepository;
    }

    @Override
    public CineplexVm getCineplexDetail(Long id) {
        Cineplex cineplex = cineplexRepository.findById(id).orElse(new Cineplex());
        return CineplexVm.fromModel(cineplex);
    }

    @Override
    public void updateCineplex(UpdateCineplexVm cineplexVm) {
        Cineplex cineplex = getCineplexById(cineplexVm.id());
        // TODO: mapping logic from cineplexVm to cineplex entity
        cineplexRepository.save(cineplex);
    }

    @Override
    public CollectionsResp getAllCineplexes(Pageable pageable) {
        Page<Cineplex> cineplexPage = cineplexRepository.findAll(pageable);

        List<CineplexVm> cineplexVms = cineplexPage.getContent().stream()
                .map(CineplexVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                cineplexPage.getTotalElements(),
                cineplexPage.getTotalPages(),
                cineplexPage.getSize(),
                cineplexPage.getNumber() + 1
        );

        return new CollectionsResp(cineplexVms, pagination);
    }

    private Cineplex getCineplexById(long cineplexId) {
        return cineplexRepository.findById(cineplexId)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.CINEPLEX_NOT_FOUND, cineplexId));
    }
}