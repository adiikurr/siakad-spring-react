package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Nilai;

@Repository
public interface NilaiRepo extends JpaRepository <Nilai, Integer>{
    @Query("SELECT COUNT(j) > 0 FROM Nilai j WHERE j.guru_id = :guru_id")
    boolean existsByGuru_id(@Param("guru_id") Integer guru_id);
}