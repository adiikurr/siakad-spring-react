package com.project.siakad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.siakad.model.Users;

public interface UsersRepo extends JpaRepository <Users, Integer>{
    Optional<Users> findByUsername(String Username);
}
