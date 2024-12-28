package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Nilai {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer nilai_id;
    
    @Column(unique = true) @NotNull private Integer guru_id;
    @Column @NotNull private Integer kkm;
    @Column @NotNull private String deskripsi_a;
    @Column @NotNull private String deskripsi_b;
    @Column @NotNull private String deskripsi_c;
    @Column @NotNull private String deskripsi_d;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getNilai_id() {
        return nilai_id;
    }

    public Integer getGuru_id() {
        return guru_id;
    }
    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
    }

    public Integer getKkm() {
        return kkm;
    }
    public void setKkm(Integer kkm) {
        this.kkm = kkm;
    }

    public String getDeskripsi_a() {
        return deskripsi_a;
    }
    public void setDeskripsi_a(String deskripsi_a) {
        this.deskripsi_a = deskripsi_a;
    }

    public String getDeskripsi_b() {
        return deskripsi_b;
    }
    public void setDeskripsi_b(String deskripsi_b) {
        this.deskripsi_b = deskripsi_b;
    }

    public String getDeskripsi_c() {
        return deskripsi_c;
    }
    public void setDeskripsi_c(String deskripsi_c) {
        this.deskripsi_c = deskripsi_c;
    }

    public String getDeskripsi_d() {
        return deskripsi_d;
    }
    public void setDeskripsi_d(String deskripsi_d) {
        this.deskripsi_d = deskripsi_d;
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
