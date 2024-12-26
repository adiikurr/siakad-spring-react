package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Mapel;
import com.project.siakad.repository.MapelRepo;
import com.project.siakad.service.MapelService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MapelServiceImpl implements MapelService {
    @Autowired private MapelRepo MapelRepo;

    @Override
    public Mapel getMapelById(Integer mapelId) {
        return MapelRepo.findById(mapelId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Mapel not found with ID: " + mapelId));
    }
    @Override
    public List<Mapel> getAllMapel(){
        return MapelRepo.findAll();
    }
    @Override
    public Mapel addMapel (Mapel mapel) {
        mapel.setCreated_at(LocalDateTime.now());
        return MapelRepo.save(mapel);
    }
    @Override
    public Mapel updateMapel (Integer id, Mapel mapel) {
        Mapel existingMapel = MapelRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Mapel not found with ID: " + id));
        
        existingMapel.setNama_mapel(mapel.getNama_mapel());
        existingMapel.setKelompok(mapel.getKelompok());
        existingMapel.setUpdated_at(LocalDateTime.now());

        return MapelRepo.save(existingMapel);
    }
    @Override
    public Mapel deleteMapelById (Integer id) {
        Mapel existingMapel = MapelRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Mapel not found with ID: " + id));

        MapelRepo.delete(existingMapel);
        return existingMapel;
    }
}
