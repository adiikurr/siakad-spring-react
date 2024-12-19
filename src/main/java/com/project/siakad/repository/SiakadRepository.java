package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.siakad.model.Users;

public interface SiakadRepository extends JpaRepository<Users, Integer>{
    
}
