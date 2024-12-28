package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Nilai;

@Repository
public interface NilaiRepo extends JpaRepository <Nilai, Integer>{

}
