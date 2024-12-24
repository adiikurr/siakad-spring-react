package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Rapot;
import com.project.siakad.model.Users;
import com.project.siakad.repository.RapotRepo;
import com.project.siakad.service.RapotService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RapotServiceImpl implements RapotService {
    @Autowired private RapotRepo RapotRepo;

    @Override
    public Rapot getRapotById(Integer rapotId) {
        return RapotRepo.findById(rapotId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Rapot not found with ID: " + rapotId));
    }
    @Override
    public List<Rapot> getAllRapot(){
        return RapotRepo.findAll();
    }
    @Override
    public Rapot addRapot (Rapot rapot) {
        // if(RapotRepo.existsByNip(rapot.getNip())) { 
        //     throw new DuplicateResourceException("NIP " + rapot.getNip() + " already exist");
        // }
        rapot.setCreated_at(LocalDateTime.now());
        return RapotRepo.save(rapot);
    }
    @Override
    public Rapot updateRapot (Integer id, Rapot rapot) {
        Rapot existingRapot = RapotRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Rapot not found with ID: " + id));
        
        // existingRapot.setNip(rapot.getNip());
        // existingRapot.setNama_rapot(rapot.getNama_rapot());
        // existingRapot.setMapel_id(rapot.getMapel_id());
        // existingRapot.setGender(rapot.getGender());
        // existingRapot.setNo_telp(rapot.getNo_telp());
        // existingRapot.setTempat_lahir(rapot.getTempat_lahir());
        // existingRapot.setTanggal_lahir(rapot.getTanggal_lahir());
        // existingRapot.setAlamat(rapot.getAlamat());
        existingRapot.setUpdated_at(LocalDateTime.now());

        return RapotRepo.save(existingRapot);
    }
    @Override
    public Rapot deleteRapotById (Integer id) {
        Rapot existingRapot = RapotRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Rapot not found with ID: " + id));

        RapotRepo.delete(existingRapot);
        return existingRapot;
    }
}
