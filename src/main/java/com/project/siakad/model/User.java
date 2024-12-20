package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer user_id;
    
    @Column @NotNull private String username;
    @Column @NotNull private String password;
    @Column private String role; 
    @Column private Integer nip; 
    @Column private Integer no_induk;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getUser_id() {
        return user_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Integer getNip() {
        return nip;
    }
    public void setNip(Integer nip) {
        this.nip = nip;
    }

    public Integer getNo_induk() {
        return no_induk;
    }
    public void setNo_induk(Integer no_induk) {
        this.no_induk = no_induk;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
}
