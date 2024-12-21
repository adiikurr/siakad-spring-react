package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Ruang;
import com.project.siakad.repository.RuangRepo;
import com.project.siakad.service.RuangService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RuangServiceImpl implements RuangService{
    @Autowired private RuangRepo RuangRepo;

    @Override
    public Ruang getRuangById(Integer ruangId) {
        return RuangRepo.findById(ruangId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Ruang not found with ID: " + ruangId));
    }
    @Override
    public List<Ruang> getAllRuang(){
        return RuangRepo.findAll();
    }
    @Override
    public Ruang addRuang (Ruang ruang) {   
        ruang.setCreated_at(LocalDateTime.now());
        return RuangRepo.save(ruang);
    }
    @Override
    public Ruang updateRuang (Integer id, Ruang ruang) {
        Ruang existingRuang = RuangRepo.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Data Ruang not found with ID: " + id));
        
        existingRuang.setNama_ruang(ruang.getNama_ruang());
        existingRuang.setUpdated_at(LocalDateTime.now());

        return RuangRepo.save(existingRuang);
    }
    @Override
    public Ruang deleteRuangById (Integer id) {
        Ruang existingRuang = RuangRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Ruang not found with ID: " + id));

        RuangRepo.delete(existingRuang);
        return existingRuang;
    }
}
