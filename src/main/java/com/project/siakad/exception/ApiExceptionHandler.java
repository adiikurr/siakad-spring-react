package com.project.siakad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.siakad.response.ApiResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String[]> errors = new HashMap<>();

        // Kumpulkan error untuk setiap atribut
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();

            errors.computeIfAbsent(fieldName, key -> new String[]{}); // Inisialisasi array
            String[] existingErrors = errors.get(fieldName);

            // Tambahkan error baru ke array existing
            String[] updatedErrors = new String[existingErrors.length + 1];
            System.arraycopy(existingErrors, 0, updatedErrors, 0, existingErrors.length);
            updatedErrors[existingErrors.length] = errorMessage;

            errors.put(fieldName, updatedErrors);
        }

        // Buat respon API
        ApiResponse response = new ApiResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                errors
        );

        return ResponseEntity.badRequest().body(response);
    }
}
