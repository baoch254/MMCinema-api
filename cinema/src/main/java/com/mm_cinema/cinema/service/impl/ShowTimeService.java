package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.ShowTime;
import com.mm_cinema.cinema.repository.ShowTimeRepository;
import com.mm_cinema.cinema.service.IShowTimeService;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.show_time.ShowTimeVm;
import com.mm_cinema.cinema.view_model.show_time.UpdateShowTimeVm;
import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ShowTimeService implements IShowTimeService {
    private final ShowTimeRepository showTimeRepository;

    public ShowTimeService(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    @Override
    public ShowTimeVm getShowTimeDetail(Long id) {
        ShowTime entity = showTimeRepository.findById(id).orElse(new ShowTime());
        return ShowTimeVm.fromModel(entity);
    }

    @Override
    public void updateShowTime(UpdateShowTimeVm vm) {
        ShowTime entity = getShowTimeById(vm.id());
        showTimeRepository.save(entity);
    }

    @Override
    public CollectionsResp getAllShowTimes(Pageable pageable) {
        Page<ShowTime> page = showTimeRepository.findAll(pageable);
        List<ShowTimeVm> vms = page.getContent().stream().map(ShowTimeVm::fromModel).collect(Collectors.toList());
        return new CollectionsResp(vms, new Pagination(page));
    }

    private ShowTime getShowTimeById(long id) {
        return showTimeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.SHOWTIME_NOT_FOUND, id));
    }
}
