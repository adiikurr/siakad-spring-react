package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.ForbiddenException;
import com.project.siakad.exception.LoginException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Session;
import com.project.siakad.repository.SessionRepo;
import com.project.siakad.service.SessionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{
    @Autowired private SessionRepo SessionRepo;

    public void validateTokenAndRole(String token, String requiredRole) {
        Session session = SessionRepo.findByToken(token)
                .orElseThrow(() -> new LoginException("Invalid token"));

        if (!session.getRole().equals(requiredRole)) {
            throw new ForbiddenException("Access denied for role: " + session.getRole());
        }

        if (session.getSessionEndTime().isBefore(LocalDateTime.now())) {
            throw new LoginException("Session expired");
        }
    }

    @Override
    public Session getSessionById(Integer sessionId) {
        return SessionRepo.findById(sessionId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Session not found with ID: " + sessionId));
    }
    @Override
    public List<Session> getAllSession(){
        return SessionRepo.findAll();
    }
}