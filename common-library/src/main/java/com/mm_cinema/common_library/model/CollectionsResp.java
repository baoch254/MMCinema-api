package com.mm_cinema.common_library.model;

import org.springframework.data.domain.Page;

import java.util.List;

public record CollectionsResp(List<?> results, Pagination pagination) {
    public static CollectionsResp fromList(List<?> results, Page<?> page) {
        return new CollectionsResp(results, new Pagination(page));
    }
}