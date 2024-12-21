package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Kelas;

public interface KelasService {
    
    public Kelas getKelasById(Integer kelasId);

    public List<Kelas> getAllKelas();

    public Kelas addKelas (Kelas kelas);

    public Kelas updateKelas (Integer id, Kelas kelas);

    public Kelas deleteKelasById (Integer id);
}
