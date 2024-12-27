package com.project.siakad.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jadwal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer jadwal_id;
    
    @Column @NotNull private Integer kelas_id;
    @Column @NotNull private Integer mapel_id;
    @Column @NotNull private Integer guru_id;
    @Column @NotNull private Integer ruang_id;
    @Column @NotNull private LocalTime jam_mulai;
    @Column @NotNull private LocalTime jam_selesai;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getJadwal_id() {
        return jadwal_id;
    }

    public Integer getKelasId() {
        return kelas_id;
    }
    public void setKelasId(Integer kelas_id) {
        this.kelas_id = kelas_id;
    }

    public Integer getMapelId() {
        return mapel_id;
    }
    public void setMapelId(Integer mapel_id) {
        this.mapel_id = mapel_id;
    }
    public Integer getGuruId() {
        return guru_id;
    }
    public void setGuruId(Integer guru_id) {
        this.guru_id = guru_id;
    }
    public Integer getRuangId() {
        return ruang_id;
    }
    public void setRuangId(Integer ruang_id) {
        this.ruang_id = ruang_id;
    }
    public LocalTime getJam_mulai() {
        return jam_mulai;
    }
    public void setJam_mulai(LocalTime jam_mulai) {
        this.jam_mulai = jam_mulai;
    }
    public LocalTime getJam_selesai() {
        return jam_selesai;
    }
    public void setJam_selesai(LocalTime jam_selesai) {
        this.jam_selesai = jam_selesai;
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
