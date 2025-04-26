package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.Cinema;
import com.mm_cinema.cinema.repository.CinemaRepository;
import com.mm_cinema.cinema.service.ICinemaService;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.cinema.CinemaVm;
import com.mm_cinema.cinema.view_model.cinema.UpdateCinemaVm;
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
public class CinemaService implements ICinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public CinemaVm getCinemaDetail(Long id) {
        Cinema cinema = cinemaRepository.findById(id).orElse(new Cinema());
        return CinemaVm.fromModel(cinema);
    }

    @Override
    public void updateCinema(UpdateCinemaVm cinemaVm) {

        Cinema cinema = getCinemaById(cinemaVm.id());
        // Update logic validate and mapping employeeVm Update vs Existed ...

        // Basic mapping
        cinemaRepository.save(cinema);
    }


    @Override
    public CollectionsResp getAllCinemas(Pageable pageable) {
        Page<Cinema> cinemaPage = cinemaRepository.findAll(pageable);

        List<CinemaVm> cinemaVms = cinemaPage.getContent().stream()
                .map(CinemaVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                cinemaPage.getTotalElements(),
                cinemaPage.getTotalPages(),
                cinemaPage.getSize(),
                cinemaPage.getNumber() + 1
        );

        return new CollectionsResp(cinemaVms, pagination);
    }

    private Cinema getCinemaById(long cinemaId){
        return cinemaRepository.findById(cinemaId).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.CINEMA_NOT_FOUND,cinemaId));
    }

}
