package com.mm_cinema.cinema.view_model.city;

import com.mm_cinema.cinema.model.City;
import com.mm_cinema.cinema.model.TicketType;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

public record GetCityDetailVm(
        Long id,
        String name,
        String provinceName,
        String region,
        LocalDateTime createdDate
) {
    public static GetCityDetailVm fromModel(City city) {
        return new GetCityDetailVm(
                city.getId(),
                city.getName(),
                city.getProvince_name(),
                city.getRegion(),
                city.getCreatedDate()
        );
    }
}