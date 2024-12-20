package com.project.siakad.response;

import java.util.Map;

public class ApiResponse {
    private int code;
    private String status;
    private Map<String, String[]> errors;

    public ApiResponse(int code, String status, Map<String, String[]> errors) {
        this.code = code;
        this.status = status;
        this.errors = errors;
    }

    // Getter dan Setter
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
