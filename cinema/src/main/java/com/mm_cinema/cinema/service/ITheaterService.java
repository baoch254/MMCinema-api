package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.theater.TheaterVm;
import com.mm_cinema.cinema.view_model.theater.UpdateTheaterVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ITheaterService {
    TheaterVm getTheaterDetail(Long id);

    void updateTheater(UpdateTheaterVm theaterVm);

    CollectionsResp getAllTheaters(Pageable pageable);
}