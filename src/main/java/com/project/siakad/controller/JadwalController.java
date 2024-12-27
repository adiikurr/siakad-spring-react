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

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Jadwal;
import com.project.siakad.service.JadwalService;
import com.project.siakad.util.ResponseUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/jadwal")
public class JadwalController {
    @Autowired private JadwalService jadwalService;

    @GetMapping("/getJadwalById/{id}")
    public ResponseEntity<?> getJadwalById(@PathVariable Integer id) {
        try {
            Jadwal jadwal = jadwalService.getJadwalById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                jadwal
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllJadwal")
    public ResponseEntity<?> getAllJadwal () {
        List<Jadwal> jadwalList = jadwalService.getAllJadwal();
        if (jadwalList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Jadwal"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                jadwalList
            );
        }
    }

    @PostMapping("/addJadwal")
    public ResponseEntity<?> addJadwal(@Valid @RequestBody Jadwal jadwal) {
        try {
            Jadwal newJadwal = jadwalService.addJadwal(jadwal);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.CREATED, 
                newJadwal
            );
        } catch (DuplicateResourceException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.CONFLICT, 
                e.getMessage()
            );
        }
    }

    @PutMapping("/updateJadwal/{id}")
    public ResponseEntity<?> updateJadwal(@PathVariable Integer id, @Valid @RequestBody Jadwal jadwal) {
        try {
            Jadwal updatedJadwal = jadwalService.updateJadwal(id, jadwal);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                updatedJadwal
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }


    @DeleteMapping("/deleteJadwalById/{id}")
    public ResponseEntity<?> deleteJadwalById(@PathVariable Integer id) {
        try {
            Jadwal deletedJadwal = jadwalService.deleteJadwalById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                deletedJadwal
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}