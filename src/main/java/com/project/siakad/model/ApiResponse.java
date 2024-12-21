package com.project.siakad.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "status", "data"})
public class ApiResponse {
    private int code;
    private String status;
    private Map<String, String[]> errors;

    public ApiResponse(int code, String status, Map<String, String[]> errors) {
        this.code = code;
        this.status = status;
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String[]> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String[]> errors) {
        this.errors = errors;
    }
}
