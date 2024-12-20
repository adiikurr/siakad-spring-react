package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Kelas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer kelas_id;
    
    @Column @NotNull private String nama_kelas;
    @Column @NotNull private Integer guru_id;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getKelas_id() {
        return kelas_id;
    }
    public String getNama_kelas() {
        return nama_kelas;
    }
    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }
    public Integer getGuru_id() {
        return guru_id;
    }
    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
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
