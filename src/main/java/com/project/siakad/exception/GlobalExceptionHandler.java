package com.project.siakad.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.siakad.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        ApiResponse response = new ApiResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "INTERNAL_SERVER_ERROR",
            Map.of("message", new String[]{ex.getMessage()})
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    
    @ExceptionHandler(LoginException.class)
        public ResponseEntity<ApiResponse> handleLoginException(LoginException ex) {
        ApiResponse response = new ApiResponse(
            HttpStatus.UNAUTHORIZED.value(),
            "UNAUTHORIZED",
            Map.of("message", new String[]{ex.getMessage()})
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse> handleDuplicateException(DuplicateResourceException ex) {
        ApiResponse response = new ApiResponse(
            HttpStatus.CONFLICT.value(),
            "CONFLICT",
            Map.of("message", new String[]{ex.getMessage()})
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse response = new ApiResponse(
            HttpStatus.NOT_FOUND.value(),
            "NOT_FOUND",
            Map.of("message", new String[]{ex.getMessage()})
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiResponse> handleForbiddenException(ForbiddenException ex) {
        ApiResponse response = new ApiResponse(
            HttpStatus.FORBIDDEN.value(),
            "FORBIDDEN",
            Map.of("message", new String[]{ex.getMessage()})
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String[]> errors = new HashMap<>();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();

            errors.computeIfAbsent(fieldName, key -> new String[]{});
            String[] existingErrors = errors.get(fieldName);

            String[] updatedErrors = new String[existingErrors.length + 1];
            System.arraycopy(existingErrors, 0, updatedErrors, 0, existingErrors.length);
            updatedErrors[existingErrors.length] = errorMessage;

            errors.put(fieldName, updatedErrors);
        }

        ApiResponse response = new ApiResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                errors
        );

        return ResponseEntity.badRequest().body(response);
    }
}
