package com.project.siakad.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiResponse> handleForbiddenException(ForbiddenException ex) {
        ApiResponse response = new ApiResponse(
            HttpStatus.FORBIDDEN.value(),
            "FORBIDDEN",
            Map.of("message", new String[]{ex.getMessage()})
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}
