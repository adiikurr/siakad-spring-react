package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Kelas;

@Repository
public interface KelasRepo extends JpaRepository <Kelas, Integer>{

}
