package com.mm_cinema.cinema.view_model.city;

import com.mm_cinema.cinema.model.City;

import java.util.List;
import java.util.stream.Collectors;

public record ListCityVm(List<CityVm> cities) {
    public static ListCityVm fromListEntity(List<City> cityEntities) {
        List<CityVm> cityVms = cityEntities.stream()
                .map(CityVm::fromModel)
                .collect(Collectors.toList());
        return new ListCityVm(cityVms);
    }
}