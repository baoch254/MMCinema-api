package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.City;
import com.mm_cinema.cinema.repository.CityRepository;
import com.mm_cinema.cinema.service.ICityService;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.city.CityVm;
import com.mm_cinema.cinema.view_model.city.UpdateCityVm;
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
public class CityService implements ICityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityVm getCityDetail(Long id) {
        City city = cityRepository.findById(id).orElse(new City());
        return CityVm.fromModel(city);
    }

    @Override
    public void updateCity(UpdateCityVm cityVm) {
        City city = getCityById(cityVm.id());
        // Update logic for fields from cityVm to city
        cityRepository.save(city);
    }

    @Override
    public CollectionsResp getAllCities(Pageable pageable) {
        Page<City> cityPage = cityRepository.findAll(pageable);

        List<CityVm> cityVms = cityPage.getContent().stream()
                .map(CityVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                cityPage.getTotalElements(),
                cityPage.getTotalPages(),
                cityPage.getSize(),
                cityPage.getNumber() + 1
        );

        return new CollectionsResp(cityVms, pagination);
    }

    private City getCityById(long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.CITY_NOT_FOUND, cityId));
    }
}
