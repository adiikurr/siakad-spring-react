package com.project.siakad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Ulangan;
import com.project.siakad.service.SessionService;
import com.project.siakad.service.UlanganService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/ulangan")
public class UlanganController {
    @Autowired private UlanganService ulanganService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getUlanganById/{id}")
    public ResponseEntity<?> getUlanganById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Ulangan ulangan = ulanganService.getUlanganById(id);

            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, ulangan);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
    
    @GetMapping("/getAllUlangan")
    public ResponseEntity<?> getAllUlangan (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Ulangan> ulanganList = ulanganService.getAllUlangan();
        
        if (ulanganList.isEmpty()) {
           throw new ResourceNotFoundException("No data found for List Ulangan");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, ulanganList);
        }
    }
}