package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Jadwal;

public interface JadwalService {

    public Jadwal getJadwalById(Integer jadwalId);

    public List<Jadwal> getAllJadwal();

    public Jadwal addJadwal (Jadwal jadwal);

    public Jadwal updateJadwal (Integer id, Jadwal jadwal);
    
    public Jadwal deleteJadwalById (Integer id);
}
