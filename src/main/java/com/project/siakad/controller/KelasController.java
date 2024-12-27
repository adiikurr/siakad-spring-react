package com.project.siakad.controller;

import java.util.List;

import jakarta.validation.Valid;
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
import com.project.siakad.model.Kelas;
import com.project.siakad.service.KelasService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/kelas")
public class KelasController {
    @Autowired private KelasService kelasService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getKelasById/{id}")
    public ResponseEntity<?> getKelasById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Kelas kelas = kelasService.getKelasById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, kelas);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
    
    @GetMapping("/getAllKelas")
    public ResponseEntity<?> getAllKelas (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Kelas> kelasList = kelasService.getAllKelas();
        if (kelasList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Kelas");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, kelasList);
        }
    }

    @PostMapping("/addKelas")
    public ResponseEntity<?> addKelas(@Valid @RequestBody Kelas kelas, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Kelas newKelas = kelasService.addKelas(kelas);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newKelas);
        } catch (DuplicateResourceException e) {
            throw new DuplicateResourceException();
        }
    }

    @PutMapping("/updateKelas/{id}")
    public ResponseEntity<?> updateKelas(@PathVariable Integer id, @Valid @RequestBody Kelas kelas, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Kelas updatedKelas = kelasService.updateKelas(id, kelas);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedKelas);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }


    @DeleteMapping("/deleteKelasById/{id}")
    public ResponseEntity<?> deleteKelasById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Kelas deletedKelas = kelasService.deleteKelasById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedKelas);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}
