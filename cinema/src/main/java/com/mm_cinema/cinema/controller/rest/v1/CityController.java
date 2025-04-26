package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.CityService;
import com.mm_cinema.cinema.view_model.city.CityVm;
import com.mm_cinema.cinema.view_model.city.UpdateCityVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCityDetail(@PathVariable Long id) {
        CityVm city = cityService.getCityDetail(id);
        return ResponseUtil.successWithData(city, "City retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateCity(@Valid @RequestBody UpdateCityVm cityVm) {
        cityService.updateCity(cityVm);
        return ResponseUtil.success("City updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCities(Pageable pageable) {
        CollectionsResp cities = cityService.getAllCities(pageable);
        return ResponseUtil.successWithCollection(cities);
    }
}