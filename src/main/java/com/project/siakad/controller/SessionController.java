package com.project.siakad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Session;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/session")
public class SessionController {
    @Autowired private SessionService sessionService;

    @GetMapping("/getSessionById/{id}")
    public ResponseEntity<?> getSessionById(@PathVariable Integer id) {
        try {
            Session session = sessionService.getSessionById(id);
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, session);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
    
    @GetMapping("/getAllSession")
    public ResponseEntity<?> getAllSession () {
        List<Session> sessionList = sessionService.getAllSession();
        if (sessionList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Session");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, sessionList);
        }
    }
}