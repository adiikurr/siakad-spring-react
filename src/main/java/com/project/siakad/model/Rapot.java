package com.project.siakad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rapot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer rapot_id;
    
    @Column @NotNull private Integer siswa_id;
    @Column @NotNull private Integer kelas_id;
    @Column @NotNull private Integer guru_id;
    @Column @NotNull private Integer mapel_id;
    @Column @NotNull private Integer prestasi_nilai;
    @Column @NotNull private String prestasi_predikat;
    @Column @NotNull private String prestasi_deskripsi;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getRapot_id() {
        return rapot_id;
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

    public Integer getPrestasi_nilai() {
        return prestasi_nilai;
    }
    public void setPrestasi_nilai(Integer prestasi_nilai) {
        this.prestasi_nilai = prestasi_nilai;
    }

    public String getPrestasi_predikat() {
        return prestasi_predikat;
    }
    public void setPrestasi_predikat(String prestasi_predikat) {
        this.prestasi_predikat = prestasi_predikat;
    }

    public String getPrestasi_deskripsi() {
        return prestasi_deskripsi;
    }
    public void setPrestasi_deskripsi(String prestasi_deskripsi) {
        this.prestasi_deskripsi = prestasi_deskripsi;
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
