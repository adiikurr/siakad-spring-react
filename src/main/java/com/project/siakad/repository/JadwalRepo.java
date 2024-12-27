package com.project.siakad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.siakad.model.Jadwal;

public interface JadwalRepo extends JpaRepository<Jadwal, Integer>{
    // Optional<Jadwal> findByKelasId(Integer kelas_id);

    // Optional<Jadwal> existsByMapelId(Integer MapelId);
    
    // Optional<Jadwal> existsByGuruId(Integer GuruId);
    
    // Optional<Jadwal> existsByRuangId(Integer RuangId);
}
