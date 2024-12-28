package com.project.siakad.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Guru;

@Repository
public interface GuruRepo extends JpaRepository<Guru, Integer>{
    boolean existsByNip(Integer nip);
}
