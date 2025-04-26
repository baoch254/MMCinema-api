package com.mm_cinema.booking.view_model.concession;

import com.mm_cinema.booking.model.Booking;
import com.mm_cinema.booking.model.Concession;

import java.util.List;
import java.util.stream.Collectors;

public record ListConcessionVm(List<ConcessionVm> concessions) {
    public static ListConcessionVm fromListEntity(List<Concession> concessions) {
        List<ConcessionVm> vmList = concessions.stream()
                .map(ConcessionVm::fromModel)
                .collect(Collectors.toList());
        return new ListConcessionVm(vmList);
    }
}