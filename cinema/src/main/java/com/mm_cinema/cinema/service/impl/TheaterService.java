package com.mm_cinema.cinema.service.impl;

import com.mm_cinema.cinema.model.Theater;
import com.mm_cinema.cinema.repository.TheaterRepository;
import com.mm_cinema.cinema.service.ITheaterService;
import com.mm_cinema.cinema.utils.Constants;
import com.mm_cinema.cinema.view_model.theater.TheaterVm;
import com.mm_cinema.cinema.view_model.theater.UpdateTheaterVm;
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
public class TheaterService implements ITheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public TheaterVm getTheaterDetail(Long id) {
        Theater entity = theaterRepository.findById(id).orElse(new Theater());
        return TheaterVm.fromModel(entity);
    }

    @Override
    public void updateTheater(UpdateTheaterVm vm) {
        Theater entity = getTheaterById(vm.id());
        theaterRepository.save(entity);
    }

    @Override
    public CollectionsResp getAllTheaters(Pageable pageable) {
        Page<Theater> page = theaterRepository.findAll(pageable);
        List<TheaterVm> vms = page.getContent().stream().map(TheaterVm::fromModel).collect(Collectors.toList());
        return new CollectionsResp(vms, new Pagination(page));
    }

    private Theater getTheaterById(long id) {
        return theaterRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.THEATER_NOT_FOUND, id));
    }
}
