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
public class Siswa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer siswa_id;
    
    @Column @NotNull private Integer no_induk;
    @Column @NotNull private Integer nisn;
    @Column @NotNull private String nama_siswa;
    @Column @NotNull private String gender;
    @Column private String no_telp; 
    @Column private String tempat_lahir; 
    @Column private LocalDate tanggal_lahir; 
    @Column private String alamat;
    @Column private String foto;
    @Column @NotNull private Integer kelas_id;
    @Column private LocalDateTime created_at;
    @Column private LocalDateTime updated_at;
    @Column private LocalDateTime deleted_at;

    public Integer getSiswa_id() {
        return siswa_id;
    }

    public Integer getNo_induk() {
        return no_induk;
    }
    public void setNo_induk(Integer no_induk) {
        this.no_induk = no_induk;
    }

    public Integer getNisn() {
        return nisn;
    }
    public void setNisn(Integer nisn) {
        this.nisn = nisn;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }
    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
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

    public Integer getKelas_id() {
        return kelas_id;
    }
    public void setKelas_id(Integer kelas_id) {
        this.kelas_id = kelas_id;
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
