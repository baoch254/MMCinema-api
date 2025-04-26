package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.Movie;
import com.mm_cinema.cinema.repository.MovieRepository;
import com.mm_cinema.cinema.service.IMovieService;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.movie.MovieVm;
import com.mm_cinema.cinema.view_model.movie.UpdateMovieVm;
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
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieVm getMovieDetail(Long id) {
        Movie movie = movieRepository.findById(id).orElse(new Movie());
        return MovieVm.fromModel(movie);
    }

    @Override
    public void updateMovie(UpdateMovieVm movieVm) {
        Movie movie = getMovieById(movieVm.id());
        movieRepository.save(movie);
    }

    @Override
    public CollectionsResp getAllMovies(Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(pageable);
        List<MovieVm> vms = page.getContent().stream().map(MovieVm::fromModel).collect(Collectors.toList());
        return new CollectionsResp(vms, new Pagination(page));
    }

    private Movie getMovieById(long id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.MOVIE_NOT_FOUND, id));
    }
}
