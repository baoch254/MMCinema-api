package com.mm_cinema.common_library.model;

import lombok.Builder;
import org.springframework.data.domain.Page;

@Builder
public record Pagination(long totalRecords, int totalPages, int pageSize, int currentPage) {
    public Pagination(Page<?> page) {
        this(page.getTotalElements(), page.getTotalPages(), page.getSize(), page.getNumber() + 1);
    }
}
