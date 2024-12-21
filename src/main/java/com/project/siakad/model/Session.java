package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer session_id;
    
    @Column(unique = true) @NotNull private String token;
    @Column(unique = true) @NotNull private Integer user_id;
    @Column(unique = true) @NotNull private String role;
    @Column private LocalDateTime sessionStartTime;
    @Column private LocalDateTime sessionEndTime;

    public Integer getSession_id() {
        return session_id;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDateTime getSessionStartTime() {
        return sessionStartTime;
    }
    public void setSessionStartTime(LocalDateTime sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }
    
    public LocalDateTime getSessionEndTime() {
        return sessionEndTime;
    }
    public void setSessionEndTime(LocalDateTime sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }
}
