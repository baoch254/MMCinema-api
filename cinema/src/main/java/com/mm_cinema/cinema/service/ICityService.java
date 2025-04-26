package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.city.CityVm;
import com.mm_cinema.cinema.view_model.city.UpdateCityVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ICityService {
    CityVm getCityDetail(Long id);

    void updateCity(UpdateCityVm cityVm);

    CollectionsResp getAllCities(Pageable pageable);
}