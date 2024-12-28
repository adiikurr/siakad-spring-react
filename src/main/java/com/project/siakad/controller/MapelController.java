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
import com.project.siakad.model.Mapel;
import com.project.siakad.service.MapelService;
import com.project.siakad.service.SessionService;
import com.project.siakad.util.ResponseUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/mapel")
public class MapelController {
    @Autowired private MapelService mapelService;
    @Autowired private SessionService sessionService;

    @GetMapping("/getMapelById/{id}")
    public ResponseEntity<?> getMapelById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Mapel mapel = mapelService.getMapelById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, mapel);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
    
    @GetMapping("/getAllMapel")
    public ResponseEntity<?> getAllMapel (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        sessionService.validateTokenAndRole(token, role);
        List<Mapel> mapelList = mapelService.getAllMapel();
        
        if (mapelList.isEmpty()) {
            throw new ResourceNotFoundException("No data found for List Mapel");
        } else {
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, mapelList);
        }
    }
    
    @PostMapping("/addMapel")
    public ResponseEntity<?> addMapel(@Valid @RequestBody Mapel mapel, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Mapel newMapel = mapelService.addMapel(mapel);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, newMapel);
        } catch (DuplicateResourceException e) {
            throw e;
        }
    }

    @PutMapping("/updateMapel/{id}")
    public ResponseEntity<?> updateMapel(@PathVariable Integer id, @Valid @RequestBody Mapel mapel, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Mapel updatedMapel = mapelService.updateMapel(id, mapel);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, updatedMapel);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    @DeleteMapping("/deleteMapelById/{id}")
    public ResponseEntity<?> deleteMapelById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            sessionService.validateTokenAndRole(token, role);
            Mapel deletedMapel = mapelService.deleteMapelById(id);
            
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, deletedMapel);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }
}