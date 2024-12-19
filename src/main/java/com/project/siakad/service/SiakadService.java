package com.project.siakad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.model.Users;
import com.project.siakad.repository.SiakadRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SiakadService {
    @Autowired private SiakadRepository siakadRepository;

    public Users getDataById(Integer id) {
        Optional<Users> siakad = siakadRepository.findById(id);
        if (siakad.isPresent()) {
            return siakad.get();
        } else {
            throw new RuntimeException("Data not found with ID: " + id);
        }
    }

    public List<Users> getData () {
        return siakadRepository.findAll();
    }

    public Users createUser (Users user) {   
        user.setCreated_at(LocalDateTime.now());
        return siakadRepository.save(user);
    }
}
