package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.movie.MovieVm;
import com.mm_cinema.cinema.view_model.movie.UpdateMovieVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface IMovieService {
    MovieVm getMovieDetail(Long id);

    void updateMovie(UpdateMovieVm movieVm);

    CollectionsResp getAllMovies(Pageable pageable);
}
