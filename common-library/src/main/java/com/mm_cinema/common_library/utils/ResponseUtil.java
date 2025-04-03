package com.mm_cinema.common_library.utils;

import com.mm_cinema.common_library.model.ApiResponse;
import com.mm_cinema.common_library.model.DataResp;
import com.mm_cinema.common_library.model.ResponseStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.mm_cinema.common_library.constants.ApiConstant.*;

public class ResponseUtil {

    public static <T> ResponseEntity<ApiResponse> successWithData(T data, String message) {
        DataResp dataResp = new DataResp(data);
        return buildSuccessResponse(dataResp, message);
    }

    public static <T> ResponseEntity<ApiResponse> successWithData(T data) {
        DataResp dataResp = new DataResp(data);
        return buildSuccessResponse(dataResp, "Success");
    }

    public static ResponseEntity<ApiResponse> success() {
        return success("Success");
    }

    public static ResponseEntity<ApiResponse> success(String message) {
        return buildSuccessResponse(null, message);
    }

    public static <T> ResponseEntity<ApiResponse> successWithCollection(T collections) {
        return buildSuccessResponse(collections, "Success");
    }

    private static <T> ResponseEntity<ApiResponse> buildSuccessResponse(T data, String message) {
        ApiResponse resp = ApiResponse.builder()
                .isSuccess(ResponseStatus.StatusSuccess)
                .message(message)
                .data(data)
                .code(SUCCESS_CODE)
                .errorCode(null)
                .build();

        return ResponseEntity.ok(resp);
    }


    public static ResponseEntity<ApiResponse> badRequest() {
        return buildErrorResponse(BAD_REQUEST_CODE, BAD_REQUEST, null);
    }

    public static ResponseEntity<ApiResponse> badRequest(String message) {
        return buildErrorResponse(BAD_REQUEST_CODE, message, null);
    }

    public static ResponseEntity<ApiResponse> badRequest(List<String> errors) {
        return buildErrorResponse(BAD_REQUEST_CODE, errors.toString(), null);
    }

    public static ResponseEntity<ApiResponse> notFound() {
        return buildErrorResponse(NOT_FOUND_CODE, NOT_FOUND, null);
    }

    public static ResponseEntity<ApiResponse> forbidden() {
        return buildErrorResponse(FORBIDDEN_CODE, FORBIDDEN, null);
    }

    public static ResponseEntity<ApiResponse> unauthorized() {
        return buildErrorResponse(UNAUTHORIZED_CODE, UNAUTHORIZED, null);
    }

    public static ResponseEntity<ApiResponse> internalError() {
        return buildErrorResponse(INTERNAL_ERROR_CODE, INTERNAL_SERVER_ERROR, null);
    }

    public static ResponseEntity<ApiResponse> internalError(String message) {
        return buildErrorResponse(INTERNAL_ERROR_CODE, message, null);
    }

    // Helper method using MessagesUtils
    public static ResponseEntity<ApiResponse> errorWithCode(int httpStatus, String errorCode, Object... args) {
        String errorMessage = MessagesUtils.getMessage(errorCode, args);
        return buildErrorResponse(httpStatus, errorMessage, errorCode);
    }

    public static ResponseEntity<ApiResponse> buildErrorResponse(Integer httpStatus, String message, String errorCode) {
        ApiResponse resp = ApiResponse.builder()
                .isSuccess(ResponseStatus.StatusFailure)
                .message(message)
                .code(httpStatus)
                .errorCode(errorCode)
                .build();

        return ResponseEntity.status(httpStatus).body(resp);
    }

}