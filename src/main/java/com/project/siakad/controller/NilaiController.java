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
import com.project.siakad.model.Nilai;
import com.project.siakad.service.NilaiService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/nilai")
public class NilaiController {
    @Autowired private NilaiService nilaiService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getNilaiById/{id}")
    public ResponseEntity<?> getNilaiById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Nilai nilai = nilaiService.getNilaiById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, nilai);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
    
    @GetMapping("/getAllNilai")
    public ResponseEntity<?> getAllNilai (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Nilai> nilaiList = nilaiService.getAllNilai();
        
        if (nilaiList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Nilai");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, nilaiList);
        }
    }

    @PostMapping("/addNilai")
    public ResponseEntity<?> addNilai(@Valid @RequestBody Nilai nilai, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Nilai newNilai = nilaiService.addNilai(nilai);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newNilai);
        } catch (DuplicateResourceException e) {
            throw e;
        }
    }

    @PutMapping("/updateNilai/{id}")
    public ResponseEntity<?> updateNilai(@PathVariable Integer id, @Valid @RequestBody Nilai nilai, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Nilai updatedNilai = nilaiService.updateNilai(id, nilai);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedNilai);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    @DeleteMapping("/deleteNilaiById/{id}")
    public ResponseEntity<?> deleteNilaiById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Nilai deletedNilai = nilaiService.deleteNilaiById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedNilai);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
}