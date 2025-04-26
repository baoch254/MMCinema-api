package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.cinema.CinemaVm;
import com.mm_cinema.cinema.view_model.cinema.UpdateCinemaVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ICinemaService {
    CinemaVm getCinemaDetail(Long id);

    void updateCinema(UpdateCinemaVm cinemaVm);

    CollectionsResp getAllCinemas(Pageable pageable);

}
