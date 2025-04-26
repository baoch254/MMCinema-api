package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.CineplexService;
import com.mm_cinema.cinema.view_model.cineplex.CineplexVm;
import com.mm_cinema.cinema.view_model.cineplex.UpdateCineplexVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cineplexes")
public class CineplexController {
    private final CineplexService cineplexService;

    public CineplexController(CineplexService cineplexService) {
        this.cineplexService = cineplexService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCineplexDetail(@PathVariable Long id) {
        CineplexVm cineplex = cineplexService.getCineplexDetail(id);
        return ResponseUtil.successWithData(cineplex, "Cineplex retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateCineplex(@Valid @RequestBody UpdateCineplexVm cineplexVm) {
        cineplexService.updateCineplex(cineplexVm);
        return ResponseUtil.success("Cineplex updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCineplexes(Pageable pageable) {
        CollectionsResp cineplexes = cineplexService.getAllCineplexes(pageable);
        return ResponseUtil.successWithCollection(cineplexes);
    }
}