package com.project.siakad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.siakad.model.Session;

@Repository
public interface SessionRepo extends JpaRepository<Session, Integer> {
    Optional<Session> findByToken(String token);
}
