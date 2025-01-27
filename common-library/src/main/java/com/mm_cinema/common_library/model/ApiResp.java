package com.mm_cinema.common_library.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class ApiResp<T> {
  private boolean success;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private ErrorResp error;

  @Data
  @Builder
  public static class ErrorResp {
    private ErrorCode code;
    private String message;
    private Object details;
  }

  @Data
  @Builder
  public static class PageResp {
    private int page;
    private int size;
    private long total;
  }
}
