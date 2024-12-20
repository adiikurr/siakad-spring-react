package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ruang {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer ruang_id;
    
    @Column @NotNull private String nama_ruang;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getRuang_id() {
        return ruang_id;
    }
    public String getNama_ruang() {
        return nama_ruang;
    }
    public void setNama_ruang(String nama_ruang) {
        this.nama_ruang = nama_ruang;
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
