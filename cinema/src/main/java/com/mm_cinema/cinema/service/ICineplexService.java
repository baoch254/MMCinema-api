package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.cineplex.CineplexVm;
import com.mm_cinema.cinema.view_model.cineplex.UpdateCineplexVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ICineplexService {

    CineplexVm getCineplexDetail(Long id);

    void updateCineplex(UpdateCineplexVm cineplexVm);

    CollectionsResp getAllCineplexes(Pageable pageable);
}