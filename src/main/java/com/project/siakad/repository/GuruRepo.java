package com.project.siakad.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.siakad.model.Guru;

public interface GuruRepo extends JpaRepository<Guru, Integer>{
    boolean existsByNip(Integer nip);
}
