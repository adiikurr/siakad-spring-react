package com.project.siakad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.siakad.model.Session;

public interface SessionRepo extends JpaRepository<Session, Integer> {
    Optional<Session> findByUserId(Integer user_id);
}
