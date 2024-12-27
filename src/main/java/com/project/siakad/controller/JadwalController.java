package com.project.siakad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Jadwal;
import com.project.siakad.service.JadwalService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/jadwal")
public class JadwalController {
    @Autowired private JadwalService jadwalService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getJadwalById/{id}")
    public ResponseEntity<?> getJadwalById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Jadwal jadwal = jadwalService.getJadwalById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, jadwal);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
    
    @GetMapping("/getAllJadwal")
    public ResponseEntity<?> getAllJadwal (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Jadwal> jadwalList = jadwalService.getAllJadwal();
        
        if (jadwalList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Jadwal");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, jadwalList);
        }
    }

    @PostMapping("/addJadwal")
    public ResponseEntity<?> addJadwal(@Valid @RequestBody Jadwal jadwal, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Jadwal newJadwal = jadwalService.addJadwal(jadwal);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newJadwal);
        } catch (DuplicateResourceException e) {
            throw new DuplicateResourceException();
        }
    }

    @PutMapping("/updateJadwal/{id}")
    public ResponseEntity<?> updateJadwal(@PathVariable Integer id, @Valid @RequestBody Jadwal jadwal, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Jadwal updatedJadwal = jadwalService.updateJadwal(id, jadwal);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedJadwal);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }

    @DeleteMapping("/deleteJadwalById/{id}")
    public ResponseEntity<?> deleteJadwalById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Jadwal deletedJadwal = jadwalService.deleteJadwalById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedJadwal);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}