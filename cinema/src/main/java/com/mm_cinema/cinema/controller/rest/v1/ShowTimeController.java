package com.mm_cinema.cinema.controller.rest.v1;

import com.mm_cinema.cinema.service.impl.ShowTimeService;
import com.mm_cinema.cinema.view_model.show_time.ShowTimeVm;
import com.mm_cinema.cinema.view_model.show_time.UpdateShowTimeVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show-times")
public class ShowTimeController {
    private final ShowTimeService showTimeService;

    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShowTimeDetail(@PathVariable Long id) {
        ShowTimeVm showTime = showTimeService.getShowTimeDetail(id);
        return ResponseUtil.successWithData(showTime, "ShowTime retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateShowTime(@Valid @RequestBody UpdateShowTimeVm showTimeVm) {
        showTimeService.updateShowTime(showTimeVm);
        return ResponseUtil.success("ShowTime updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllShowTimes(Pageable pageable) {
        CollectionsResp showTimes = showTimeService.getAllShowTimes(pageable);
        return ResponseUtil.successWithCollection(showTimes);
    }
}