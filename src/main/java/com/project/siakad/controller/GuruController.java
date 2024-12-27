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
import com.project.siakad.model.Guru;
import com.project.siakad.service.GuruService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/guru")
public class GuruController {
    @Autowired private GuruService guruService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getGuruById/{id}")
    public ResponseEntity<?> getGuruById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Guru guru = guruService.getGuruById(id);
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, guru);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
    
    @GetMapping("/getAllGuru")
    public ResponseEntity<?> getAllGuru (@RequestHeader("token") String token, @RequestHeader("role") String role) {
            sessionService.validateTokenAndRole(token, role);
            List<Guru> guruList = guruService.getAllGuru();
            if (guruList.isEmpty()) {
                throw new ResourceNotFoundException("No data found for List Guru");
            } else {
                return ResponseUtil.generateSuccessResponse(HttpStatus.OK, guruList);
            }
    }

    @PostMapping("/addGuru")
    public ResponseEntity<?> addGuru(@Valid @RequestBody Guru guru, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Guru newGuru = guruService.addGuru(guru);
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newGuru);
        } catch (DuplicateResourceException e) {
            throw e;
        }
    }
    
    @PutMapping("/updateGuru/{id}")
    public ResponseEntity<?> updateGuru(@PathVariable Integer id, @Valid @RequestBody Guru guru, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Guru updatedGuru = guruService.updateGuru(id, guru);
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedGuru);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
    
    @DeleteMapping("/deleteGuruById/{id}")
    public ResponseEntity<?> deleteGuruById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Guru deletedGuru = guruService.deleteGuruById(id);
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedGuru);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
}
