package com.mm_cinema.cinema.view_model.city;

import com.mm_cinema.cinema.model.City;
import com.mm_cinema.cinema.model.TicketType;

public record UpdateCityVm(
        Long id,
        String name,
        String provinceName,
        String region
) {
    public City toCity() {
        return City.builder()
                .id(id)
                .name(name)
                .province_name(provinceName)
                .region(region)
                .build();
    }
}