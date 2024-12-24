package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Nilai;
import com.project.siakad.model.Users;
import com.project.siakad.repository.NilaiRepo;
import com.project.siakad.service.NilaiService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        // if(NilaiRepo.existsByNip(nilai.getNip())) { 
        //     throw new DuplicateResourceException("NIP " + nilai.getNip() + " already exist");
        // }
        nilai.setCreated_at(LocalDateTime.now());
        return NilaiRepo.save(nilai);
    }
    @Override
    public Nilai updateNilai (Integer id, Nilai nilai) {
        Nilai existingNilai = NilaiRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Nilai not found with ID: " + id));
        
        // existingNilai.setNip(nilai.getNip());
        // existingNilai.setNama_nilai(nilai.getNama_nilai());
        // existingNilai.setMapel_id(nilai.getMapel_id());
        // existingNilai.setGender(nilai.getGender());
        // existingNilai.setNo_telp(nilai.getNo_telp());
        // existingNilai.setTempat_lahir(nilai.getTempat_lahir());
        // existingNilai.setTanggal_lahir(nilai.getTanggal_lahir());
        // existingNilai.setAlamat(nilai.getAlamat());
        existingNilai.setUpdated_at(LocalDateTime.now());

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
