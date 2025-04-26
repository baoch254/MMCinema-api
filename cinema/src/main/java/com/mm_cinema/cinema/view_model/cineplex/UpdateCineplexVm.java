package com.mm_cinema.cinema.view_model.cineplex;

import com.mm_cinema.cinema.model.Cineplex;

public record UpdateCineplexVm(
        Long id,
        String name,
        String code,
        String avatar,
        String logo
) {
    public Cineplex toCineplex() {
        return Cineplex.builder()
                .id(id)
                .name(name)
                .code(code)
                .avatar(avatar)
                .logo(logo)
                .build();
    }
}