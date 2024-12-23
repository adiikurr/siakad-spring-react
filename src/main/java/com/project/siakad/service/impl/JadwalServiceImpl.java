package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Jadwal;
import com.project.siakad.repository.JadwalRepo;
import com.project.siakad.service.JadwalService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JadwalServiceImpl implements JadwalService {
    @Autowired private JadwalRepo JadwalRepo;

    @Override
    public Jadwal getJadwalById(Integer jadwalId) {
        return JadwalRepo.findById(jadwalId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Jadwal not found with ID: " + jadwalId));
    }
    @Override
    public List<Jadwal> getAllJadwal(){
        return JadwalRepo.findAll();
    }
    @Override
    public Jadwal addJadwal (Jadwal jadwal) {
        // if(JadwalRepo.existsByNip(jadwal.getNip())) { 
        //     throw new DuplicateResourceException("NIP " + jadwal.getNip() + " already exist");
        // }
        jadwal.setCreated_at(LocalDateTime.now());
        return JadwalRepo.save(jadwal);
    }
    @Override
    public Jadwal updateJadwal (Integer id, Jadwal jadwal) {
        Jadwal existingJadwal = JadwalRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Jadwal not found with ID: " + id));
        
        // existingJadwal.setNip(jadwal.getNip());
        // existingJadwal.setNama_jadwal(jadwal.getNama_jadwal());
        // existingJadwal.setMapel_id(jadwal.getMapel_id());
        // existingJadwal.setGender(jadwal.getGender());
        // existingJadwal.setNo_telp(jadwal.getNo_telp());
        // existingJadwal.setTempat_lahir(jadwal.getTempat_lahir());
        // existingJadwal.setTanggal_lahir(jadwal.getTanggal_lahir());
        // existingJadwal.setAlamat(jadwal.getAlamat());
        existingJadwal.setUpdated_at(LocalDateTime.now());

        return JadwalRepo.save(existingJadwal);
    }
    @Override
    public Jadwal deleteJadwalById (Integer id) {
        Jadwal existingJadwal = JadwalRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Jadwal not found with ID: " + id));

        JadwalRepo.delete(existingJadwal);
        return existingJadwal;
    }
}
