package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.MovieService;
import com.mm_cinema.cinema.view_model.movie.MovieVm;
import com.mm_cinema.cinema.view_model.movie.UpdateMovieVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieDetail(@PathVariable Long id) {
        MovieVm movie = movieService.getMovieDetail(id);
        return ResponseUtil.successWithData(movie, "Movie retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateMovie(@Valid @RequestBody UpdateMovieVm movieVm) {
        movieService.updateMovie(movieVm);
        return ResponseUtil.success("Movie updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMovies(Pageable pageable) {
        CollectionsResp movies = movieService.getAllMovies(pageable);
        return ResponseUtil.successWithCollection(movies);
    }
}