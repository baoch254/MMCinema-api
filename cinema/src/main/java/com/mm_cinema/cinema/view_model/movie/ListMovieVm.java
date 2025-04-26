package com.mm_cinema.cinema.view_model.movie;

import com.mm_cinema.cinema.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

public record ListMovieVm(List<MovieVm> movies) {
    public static ListMovieVm fromListEntity(List<Movie> movieEntities) {
        List<MovieVm> movieVms = movieEntities.stream()
                .map(MovieVm::fromModel)
                .collect(Collectors.toList());
        return new ListMovieVm(movieVms);
    }
}