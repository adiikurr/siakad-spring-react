package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Guru;
import com.project.siakad.repository.GuruRepo;
import com.project.siakad.service.GuruService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GuruServiceImpl implements GuruService {
    @Autowired private GuruRepo GuruRepo;

    @Override
    public Guru getGuruById(Integer guruId) {
        return GuruRepo.findById(guruId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Guru not found with ID: " + guruId));
    }
    @Override
    public List<Guru> getAllGuru(){
        return GuruRepo.findAll();
    }
    @Override
    public Guru addGuru (Guru guru) {   
        guru.setCreated_at(LocalDateTime.now());
        return GuruRepo.save(guru);
    }
    @Override
    public Guru updateGuru (Integer id, Guru guru) {
        Guru existingGuru = GuruRepo.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Data Guru not found with ID: " + id));
        
        existingGuru.setNip(guru.getNip());
        existingGuru.setNama_guru(guru.getNama_guru());
        existingGuru.setMapel_id(guru.getMapel_id());
        existingGuru.setGender(guru.getGender());
        existingGuru.setNo_telp(guru.getNo_telp());
        existingGuru.setTempat_lahir(guru.getTempat_lahir());
        existingGuru.setTanggal_lahir(guru.getTanggal_lahir());
        existingGuru.setAlamat(guru.getAlamat());

        return GuruRepo.save(existingGuru);
    }
    @Override
    public Guru deleteGuruById (Integer id) {
        Guru existingGuru = GuruRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Guru not found with ID: " + id));

        GuruRepo.delete(existingGuru);
        return existingGuru;
    }
}
