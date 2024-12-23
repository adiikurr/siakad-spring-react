package com.project.siakad.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Guru {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer guru_id;
    
    @Column(unique = true) @NotNull private Integer nip;
    @Column @NotNull private String nama_guru;
    @Column @NotNull private Integer mapel_id;
    @Column @NotNull private String gender;
    @Column private String no_telp; 
    @Column private String tempat_lahir; 
    @Column private LocalDate tanggal_lahir; 
    @Column private String alamat;
    @Column private String foto;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getGuru_id() {
        return guru_id;
    }
    public Integer getNip() {
        return nip;
    }
    public void setNip(Integer nip) {
        this.nip = nip;
    }

    public String getNama_guru() {
        return nama_guru;
    }
    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public Integer getMapel_id() {
        return mapel_id;
    }
    public void setMapel_id(Integer mapel_id) {
        this.mapel_id = mapel_id;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getNo_telp() {
        return no_telp;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }
    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public LocalDate getTanggal_lahir() {
        return tanggal_lahir;
    }
    public void setTanggal_lahir(LocalDate tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
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
