package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Ulangan;
import com.project.siakad.repository.UlanganRepo;
import com.project.siakad.service.UlanganService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UlanganServiceImpl implements UlanganService {
    @Autowired private UlanganRepo UlanganRepo;

    @Override
    public Ulangan getUlanganById(Integer ulanganId) {
        return UlanganRepo.findById(ulanganId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Ulangan not found with ID: " + ulanganId));
    }
    @Override
    public List<Ulangan> getAllUlangan(){
        return UlanganRepo.findAll();
    }
    @Override
    public Ulangan addUlangan (Ulangan ulangan) {
        ulangan.setCreated_at(LocalDateTime.now());
        return UlanganRepo.save(ulangan);
    }
    @Override
    public Ulangan updateUlangan (Integer id, Ulangan ulangan) {
        Ulangan existingUlangan = UlanganRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Ulangan not found with ID: " + id));
        
        // existingUlangan.setNip(ulangan.getNip());
        // existingUlangan.setNama_ulangan(ulangan.getNama_ulangan());
        // existingUlangan.setMapel_id(ulangan.getMapel_id());
        // existingUlangan.setGender(ulangan.getGender());
        // existingUlangan.setNo_telp(ulangan.getNo_telp());
        // existingUlangan.setTempat_lahir(ulangan.getTempat_lahir());
        // existingUlangan.setTanggal_lahir(ulangan.getTanggal_lahir());
        // existingUlangan.setAlamat(ulangan.getAlamat());
        existingUlangan.setUpdated_at(LocalDateTime.now());

        return UlanganRepo.save(existingUlangan);
    }
    @Override
    public Ulangan deleteUlanganById (Integer id) {
        Ulangan existingUlangan = UlanganRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Ulangan not found with ID: " + id));

        UlanganRepo.delete(existingUlangan);
        return existingUlangan;
    }
}
