package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Siswa;

@Repository
public interface SiswaRepo extends JpaRepository<Siswa, Integer>{

}
