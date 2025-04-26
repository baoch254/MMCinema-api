package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.CinemaService;
import com.mm_cinema.cinema.view_model.cinema.CinemaVm;
import com.mm_cinema.cinema.view_model.cinema.UpdateCinemaVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCinemaDetail(@PathVariable Long id) {
        CinemaVm cinema = cinemaService.getCinemaDetail(id);
        return ResponseUtil.successWithData(cinema, "Cinema retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateCinema(@Valid @RequestBody UpdateCinemaVm cinemaVm) {
        cinemaService.updateCinema(cinemaVm);
        return ResponseUtil.success("Cinema updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCinemas(Pageable pageable) {
        CollectionsResp cinemas = cinemaService.getAllCinemas(pageable);
        return ResponseUtil.successWithCollection(cinemas);
    }
}