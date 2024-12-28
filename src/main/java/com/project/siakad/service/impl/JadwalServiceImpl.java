package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.DuplicateResourceException;
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
        if(JadwalRepo.existsByUniqueCombination(jadwal.getGuru_id(), jadwal.getKelas_id(), jadwal.getMapel_id(), jadwal.getRuang_id())) { 
            throw new DuplicateResourceException("This Jadwal already exist");
        }
        jadwal.setCreated_at(LocalDateTime.now());
        return JadwalRepo.save(jadwal);
    }
    @Override
    public Jadwal updateJadwal (Integer id, Jadwal jadwal) {
        Jadwal existingJadwal = JadwalRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Jadwal not found with ID: " + id));
        
        if(JadwalRepo.existsByUniqueCombination(jadwal.getGuru_id(), jadwal.getKelas_id(), jadwal.getMapel_id(), jadwal.getRuang_id())) { 
            throw new DuplicateResourceException("This Jadwal already exist");
        } else {
            existingJadwal.setGuru_id(jadwal.getGuru_id());
            existingJadwal.setKelas_id(jadwal.getKelas_id());
            existingJadwal.setMapel_id(jadwal.getMapel_id());
            existingJadwal.setRuang_id(jadwal.getRuang_id());
            existingJadwal.setJam_mulai(jadwal.getJam_mulai());
            existingJadwal.setJam_selesai(jadwal.getJam_selesai());
            existingJadwal.setUpdated_at(LocalDateTime.now());
        }
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
