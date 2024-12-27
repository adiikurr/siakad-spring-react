package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Session;

public interface SessionService {
    public Session getSessionById(Integer sessionId);

    public List<Session> getAllSession();

    public void validateTokenAndRole(String token, String requiredRole);
}