package com.project.siakad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.siakad.model.User;

public interface UserRepo extends JpaRepository <User, Integer>{

}
