package com.project.siakad.util;

import com.project.siakad.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<ApiResponse> generateErrorResponse(HttpStatus status, String message) {
        ApiResponse response = new ApiResponse(
            status.value(),
            status.name(),
            Map.of("general", new String[]{message})
        );
        return ResponseEntity.status(status).body(response);
    }

    public static <T> ResponseEntity<Map<String, Object>> generateSuccessResponse(HttpStatus status, T data) {
        Map<String, Object> response = Map.of(
            "code", status.value(),
            "status", status.name(),
            "data", data
        );
        return ResponseEntity.status(status).body(response);
    }
}
