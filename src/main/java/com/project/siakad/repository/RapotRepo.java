package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Rapot;

@Repository
public interface RapotRepo extends JpaRepository <Rapot, Integer>{

}
