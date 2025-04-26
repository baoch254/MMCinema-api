package com.mm_cinema.cinema.view_model.city;

import com.mm_cinema.cinema.model.City;

import java.time.LocalDateTime;

public record CityVm(
        Long id,
        String name,
        String provinceName,
        String region,
        LocalDateTime createdDate
) {
    public static CityVm fromModel(City city) {
        return new CityVm(
                city.getId(),
                city.getName(),
                city.getProvince_name(),
                city.getRegion(),
                city.getCreatedDate()
        );
    }
}