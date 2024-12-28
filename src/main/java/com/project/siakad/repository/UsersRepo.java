package com.project.siakad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Users;

@Repository
public interface UsersRepo extends JpaRepository <Users, Integer>{
    Optional<Users> findByUsername(String Username);
}
