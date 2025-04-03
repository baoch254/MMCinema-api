package com.mm_cinema.common_library.exception;

import com.mm_cinema.common_library.model.ApiResponse;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import static com.mm_cinema.common_library.constants.ApiConstant.INTERNAL_ERROR_CODE;
import static com.mm_cinema.common_library.utils.ResponseUtil.*;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    private static final String ERROR_LOG_FORMAT = "Error: URI: {}, ErrorCode: {}, Message: {}";
    private static final String INVALID_REQUEST_INFORMATION_MESSAGE = "Request information is not valid";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return ResponseUtil.notFound();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                   WebRequest request) {

        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getField() + " " + error.getDefaultMessage())
            .toList();

        return badRequest(errors);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    protected ResponseEntity<ApiResponse> handleHandlerMethodValidationException(HandlerMethodValidationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<String> errors = ex.getAllErrors().stream()
            .map(error -> {
                if (error instanceof FieldError fieldError) {
                    return fieldError.getField() + " " + fieldError.getDefaultMessage();
                }
                return error.getDefaultMessage();
            }).toList();

        return  badRequest(errors);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponse> handleOtherException(Exception ex, WebRequest request) {
        log.error(ERROR_LOG_FORMAT, getServletPath(request), INTERNAL_ERROR_CODE, ex.getMessage());
        return ResponseUtil.internalError(ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException ex, WebRequest request) {
        return badRequest();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiResponse> handleConstraintViolation(ConstraintViolationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<String> errors = ex.getConstraintViolations().stream()
            .map(violation -> String.format("%s %s: %s",
                violation.getRootBeanClass().getName(),
                violation.getPropertyPath(),
                violation.getMessage()))
            .toList();

        return badRequest(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return handleBadRequest(ex, null);
    }

    @ExceptionHandler(DuplicatedException.class)
    protected ResponseEntity<ApiResponse> handleDuplicated(DuplicatedException ex) {
        return handleBadRequest(ex, null);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    protected ResponseEntity<ApiResponse> handleInternalServerErrorException(InternalServerErrorException e) {
        log.error("Internal server error exception: ", e);
        return internalError();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ApiResponse> handleMissingParams(MissingServletRequestParameterException e) {
        return handleBadRequest(e, null);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return forbidden();
    }

    @ExceptionHandler(WrongEmailFormatException.class)
    public ResponseEntity<ApiResponse> handleWrongEmailFormatException(WrongEmailFormatException ex, WebRequest request) {
        return handleBadRequest(ex, request);
    }

    @ExceptionHandler({Forbidden.class})
    public ResponseEntity<ApiResponse> handleForbidden(NotFoundException ex, WebRequest request) {
        return ResponseUtil.forbidden();
    }

    private String getServletPath(WebRequest webRequest) {
        ServletWebRequest servletRequest = (ServletWebRequest) webRequest;
        return servletRequest.getRequest().getServletPath();
    }

    private ResponseEntity<ApiResponse> handleBadRequest(Exception ex, WebRequest request) {
        return badRequest(ex.getMessage());
    }
}