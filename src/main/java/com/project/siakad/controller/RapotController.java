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
import com.project.siakad.model.Rapot;
import com.project.siakad.service.RapotService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/rapot")
public class RapotController {
    @Autowired private RapotService rapotService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getRapotById/{id}")
    public ResponseEntity<?> getRapotById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Rapot rapot = rapotService.getRapotById(id);

            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, rapot);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
    
    @GetMapping("/getAllRapot")
    public ResponseEntity<?> getAllRapot (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Rapot> rapotList = rapotService.getAllRapot();
        
        if (rapotList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Rapot");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, rapotList);
        }
    }

        @PostMapping("/addRapot")
    public ResponseEntity<?> addRapot(@Valid @RequestBody Rapot rapot, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Rapot newRapot = rapotService.addRapot(rapot);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newRapot);
        } catch (DuplicateResourceException e) {
            throw e;
        }
    }

    @PutMapping("/updateRapot/{id}")
    public ResponseEntity<?> updateRapot(@PathVariable Integer id, @Valid @RequestBody Rapot rapot, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Rapot updatedRapot = rapotService.updateRapot(id, rapot);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedRapot);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    @DeleteMapping("/deleteRapotById/{id}")
    public ResponseEntity<?> deleteRapotById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Rapot deletedRapot = rapotService.deleteRapotById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedRapot);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
}