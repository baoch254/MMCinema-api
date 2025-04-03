package com.mm_cinema.common_library.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse(
        @JsonProperty("is_success") ResponseStatus isSuccess,
        String message,
        Object data,
        Integer code,
        @JsonProperty("error_code") String errorCode
) {}