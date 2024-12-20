package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Mapel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer mapel_id;
    
    @Column @NotNull private String nama_mapel;
    @Column @NotNull private String kelompok;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getMapel_id() {
        return mapel_id;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }
    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getKelompok() {
        return kelompok;
    }
    public void setKelompok(String kelompok) {
        this.kelompok = kelompok;
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
