package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Ruang;

@Repository
public interface RuangRepo extends JpaRepository <Ruang, Integer> {

}
