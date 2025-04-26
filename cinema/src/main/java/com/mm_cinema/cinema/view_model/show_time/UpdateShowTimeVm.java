package com.mm_cinema.cinema.view_model.show_time;

import com.mm_cinema.cinema.model.ShowTime;

import java.time.LocalDateTime;

public record UpdateShowTimeVm(
        Long id,
        Integer apiCinemaId,
        Integer apiFilmId,
        LocalDateTime showTime,
        Integer duration,
        String showTimeDuration,
        String screenName,
        String showTimeLink
) {
    public ShowTime toShowTime() {
        return ShowTime.builder()
                .id(id)
                .apiCinemaId(apiCinemaId)
                .apiFilmId(apiFilmId)
                .showTime(showTime)
                .duration(duration)
                .showTimeDuration(showTimeDuration)
                .screenName(screenName)
                .showTimeLink(showTimeLink)
                .build();
    }
}