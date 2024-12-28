package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Nilai;
import com.project.siakad.repository.NilaiRepo;
import com.project.siakad.service.NilaiService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NilaiServiceImpl implements NilaiService {
    @Autowired private NilaiRepo NilaiRepo;

    @Override
    public Nilai getNilaiById(Integer nilaiId) {
        return NilaiRepo.findById(nilaiId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Nilai not found with ID: " + nilaiId));
    }
    @Override
    public List<Nilai> getAllNilai(){
        return NilaiRepo.findAll();
    }
    @Override
    public Nilai addNilai (Nilai nilai) {
        if(NilaiRepo.existsByGuru_id(nilai.getGuru_id())) { 
            throw new DuplicateResourceException("This Nilai for Guru ID : " + nilai.getGuru_id() + " already exist");
        }
        nilai.setCreated_at(LocalDateTime.now());
        return NilaiRepo.save(nilai);
    }
    @Override
    public Nilai updateNilai (Integer id, Nilai nilai) {
        Nilai existingNilai = NilaiRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Nilai not found with ID: " + id));
        
        if(NilaiRepo.existsByGuru_id(nilai.getGuru_id())) { 
            throw new DuplicateResourceException("This Nilai for Guru ID : " + nilai.getGuru_id() + " already exist");
        } else {
            existingNilai.setGuru_id(nilai.getGuru_id());
            existingNilai.setKkm(nilai.getKkm());
            existingNilai.setDeskripsi_a(nilai.getDeskripsi_a());
            existingNilai.setDeskripsi_b(nilai.getDeskripsi_b());
            existingNilai.setDeskripsi_c(nilai.getDeskripsi_c());
            existingNilai.setDeskripsi_d(nilai.getDeskripsi_d());
            existingNilai.setUpdated_at(LocalDateTime.now());
        }
        return NilaiRepo.save(existingNilai);
    }
    @Override
    public Nilai deleteNilaiById (Integer id) {
        Nilai existingNilai = NilaiRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Nilai not found with ID: " + id));

        NilaiRepo.delete(existingNilai);
        return existingNilai;
    }
}
