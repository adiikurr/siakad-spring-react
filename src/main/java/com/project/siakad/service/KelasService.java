package com.project.siakad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Kelas;
import com.project.siakad.repository.KelasRepo;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KelasService {
    @Autowired private KelasRepo KelasRepo;

    public Kelas getKelasById(Integer kelasId) {
        return KelasRepo.findById(kelasId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Kelas not found with ID: " + kelasId));
    }

    public List<Kelas> getAllKelas(){
        return KelasRepo.findAll();
    }

    public Kelas addKelas (Kelas kelas) {   
        kelas.setCreated_at(LocalDateTime.now());
        return KelasRepo.save(kelas);
    }

    public Kelas updateKelas (Integer id, Kelas kelas) {
        Kelas existingKelas = KelasRepo.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Data Kelas not found with ID: " + id));
        
        existingKelas.setNama_kelas(kelas.getNama_kelas());
        existingKelas.setGuru_id(kelas.getGuru_id());

        return KelasRepo.save(existingKelas);
    }

    public Kelas deleteKelasById (Integer id) {
        Kelas existingKelas = KelasRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Kelas not found with ID: " + id));

        KelasRepo.delete(existingKelas);
        return existingKelas;
    }
}
