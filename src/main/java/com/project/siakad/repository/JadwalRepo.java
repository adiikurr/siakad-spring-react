package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Jadwal;

@Repository
public interface JadwalRepo extends JpaRepository<Jadwal, Integer> {

    @Query("SELECT COUNT(j) > 0 FROM Jadwal j WHERE j.guru_id = :guru_id AND j.kelas_id = :kelas_id AND j.mapel_id = :mapel_id AND j.ruang_id = :ruang_id")
    boolean existsByUniqueCombination(@Param("guru_id") Integer guru_id, 
                                       @Param("kelas_id") Integer kelas_id, 
                                       @Param("mapel_id") Integer mapel_id, 
                                       @Param("ruang_id") Integer ruang_id);
}
