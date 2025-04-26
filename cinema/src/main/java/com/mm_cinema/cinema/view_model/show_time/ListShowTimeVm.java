package com.mm_cinema.cinema.view_model.show_time;

import com.mm_cinema.cinema.model.Seat;
import com.mm_cinema.cinema.model.ShowTime;

import java.util.List;
import java.util.stream.Collectors;

public record ListShowTimeVm(List<ShowTimeVm> showTimes) {
    public static ListShowTimeVm fromListEntity(List<ShowTime> showTimeEntities) {
        List<ShowTimeVm> showTimeVms = showTimeEntities.stream()
                .map(ShowTimeVm::fromModel)
                .collect(Collectors.toList());
        return new ListShowTimeVm(showTimeVms);
    }
}