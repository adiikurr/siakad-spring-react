package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Session;
import com.project.siakad.repository.SessionRepo;
import com.project.siakad.service.SessionService;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{
    @Autowired private SessionRepo SessionRepo;

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