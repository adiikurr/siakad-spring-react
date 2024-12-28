package com.project.siakad.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ulangan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer ulangan_id;
    
    @Column @NotNull private Integer siswa_id;
    @Column @NotNull private Integer kelas_id;
    @Column @NotNull private Integer guru_id;
    @Column @NotNull private Integer mapel_id;
    @Column private Integer ulha;
    @Column private Integer uts;
    @Column private Integer uas;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getUlangan_id() {
        return ulangan_id;
    }
    public Integer getSiswa_id() {
        return siswa_id;
    }
    public void setSiswa_id(Integer siswa_id) {
        this.siswa_id = siswa_id;
    }

    public Integer getKelas_id() {
        return kelas_id;
    }
    public void setKelas_id(Integer kelas_id) {
        this.kelas_id = kelas_id;
    }

    public Integer getGuru_id() {
        return guru_id;
    }
    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
    }

    public Integer getMapel_id() {
        return mapel_id;
    }
    public void setMapel_id(Integer mapel_id) {
        this.mapel_id = mapel_id;
    }

    public Integer getUlha() {
        return ulha;
    }
    public void setUlha(Integer ulha) {
        this.ulha = ulha;
    }

    public Integer getUts() {
        return uts;
    }
    public void setUts(Integer uts) {
        this.uts = uts;
    }

    public Integer getUas() {
        return uas;
    }
    public void setUas(Integer uas) {
        this.uas = uas;
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
