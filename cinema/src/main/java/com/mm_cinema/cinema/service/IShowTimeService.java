package com.mm_cinema.cinema.service;

import com.mm_cinema.cinema.view_model.show_time.ShowTimeVm;
import com.mm_cinema.cinema.view_model.show_time.UpdateShowTimeVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface IShowTimeService {
    ShowTimeVm getShowTimeDetail(Long id);

    void updateShowTime(UpdateShowTimeVm showTimeVm);

    CollectionsResp getAllShowTimes(Pageable pageable);
}