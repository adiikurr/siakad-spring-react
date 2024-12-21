package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Kelas;
import com.project.siakad.repository.KelasRepo;
import com.project.siakad.service.KelasService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KelasServiceImpl implements KelasService{
    @Autowired private KelasRepo KelasRepo;

    @Override
    public Kelas getKelasById(Integer kelasId) {
        return KelasRepo.findById(kelasId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Kelas not found with ID: " + kelasId));
    }

    @Override
    public List<Kelas> getAllKelas(){
        return KelasRepo.findAll();
    }

    @Override
    public Kelas addKelas (Kelas kelas) {   
        kelas.setCreated_at(LocalDateTime.now());
        return KelasRepo.save(kelas);
    }

    @Override
    public Kelas updateKelas (Integer id, Kelas kelas) {
        Kelas existingKelas = KelasRepo.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Data Kelas not found with ID: " + id));
        
        existingKelas.setNama_kelas(kelas.getNama_kelas());
        existingKelas.setGuru_id(kelas.getGuru_id());
        existingKelas.setUpdated_at(LocalDateTime.now());

        return KelasRepo.save(existingKelas);
    }

    @Override
    public Kelas deleteKelasById (Integer id) {
        Kelas existingKelas = KelasRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Kelas not found with ID: " + id));

        KelasRepo.delete(existingKelas);
        return existingKelas;
    }
}
