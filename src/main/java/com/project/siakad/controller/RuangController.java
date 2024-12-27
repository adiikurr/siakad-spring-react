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
import com.project.siakad.model.Ruang;
import com.project.siakad.service.RuangService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/ruang")
public class RuangController {
    @Autowired private RuangService ruangService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getRuangById/{id}")
    public ResponseEntity<?> getRuangById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Ruang ruang = ruangService.getRuangById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, ruang);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
    
    @GetMapping("/getAllRuang")
    public ResponseEntity<?> getAllRuang (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Ruang> ruangList = ruangService.getAllRuang();
        
        if (ruangList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Ruang");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, ruangList);
        }
    }

    @PostMapping("/addRuang")
    public ResponseEntity<?> addRuang(@Valid @RequestBody Ruang ruang, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Ruang newRuang = ruangService.addRuang(ruang);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newRuang);
        } catch (DuplicateResourceException e) {
            throw new DuplicateResourceException();
        }
    }

    @PutMapping("/updateRuang/{id}")
    public ResponseEntity<?> updateRuang(@PathVariable Integer id, @Valid @RequestBody Ruang ruang, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Ruang updatedRuang = ruangService.updateRuang(id, ruang);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedRuang);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }


    @DeleteMapping("/deleteRuangById/{id}")
    public ResponseEntity<?> deleteRuangById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Ruang deletedRuang = ruangService.deleteRuangById(id);

            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedRuang);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}
