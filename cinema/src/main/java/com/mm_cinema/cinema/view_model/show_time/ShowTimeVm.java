package com.mm_cinema.cinema.view_model.show_time;

import com.mm_cinema.cinema.model.ShowTime;

import java.time.LocalDateTime;

public record ShowTimeVm(
        Long id,
        Integer apiCinemaId,
        Integer apiFilmId,
        LocalDateTime showTime,
        Integer duration,
        String showTimeDuration,
        String screenName,
        String showTimeLink,
        LocalDateTime createdDate
) {
    public static ShowTimeVm fromModel(ShowTime showTime) {
        return new ShowTimeVm(
                showTime.getId(),
                showTime.getApiCinemaId(),
                showTime.getApiFilmId(),
                showTime.getShowTime(),
                showTime.getDuration(),
                showTime.getShowTimeDuration(),
                showTime.getScreenName(),
                showTime.getShowTimeLink(),
                showTime.getCreatedDate()
        );
    }
}