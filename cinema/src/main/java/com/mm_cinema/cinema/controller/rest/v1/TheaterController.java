package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.TheaterService;
import com.mm_cinema.cinema.view_model.theater.TheaterVm;
import com.mm_cinema.cinema.view_model.theater.UpdateTheaterVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTheaterDetail(@PathVariable Long id) {
        TheaterVm theater = theaterService.getTheaterDetail(id);
        return ResponseUtil.successWithData(theater, "Theater retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateTheater(@Valid @RequestBody UpdateTheaterVm theaterVm) {
        theaterService.updateTheater(theaterVm);
        return ResponseUtil.success("Theater updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTheaters(Pageable pageable) {
        CollectionsResp theaters = theaterService.getAllTheaters(pageable);
        return ResponseUtil.successWithCollection(theaters);
    }
}