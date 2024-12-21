package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Siswa;

public interface SiswaService {
    public Siswa getSiswaById(Integer siswaId);

    public List<Siswa> getAllSiswa();

    public Siswa addSiswa (Siswa siswa);

    public Siswa updateSiswa (Integer id, Siswa siswa);
    
    public Siswa deleteSiswaById (Integer id);
}
