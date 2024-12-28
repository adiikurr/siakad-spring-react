package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Mapel;

@Repository
public interface MapelRepo extends JpaRepository <Mapel, Integer>{

}
