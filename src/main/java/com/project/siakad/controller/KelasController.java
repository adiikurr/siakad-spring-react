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

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Kelas;
import com.project.siakad.service.KelasService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/kelas")
public class KelasController {
    @Autowired private KelasService kelasService;

    @GetMapping("/getKelasById/{id}")
    public ResponseEntity<?> getKelasById(@PathVariable Integer id) {
        try {
            Kelas kelas = kelasService.getKelasById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                kelas
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllKelas")
    public ResponseEntity<?> getAllKelas () {
        List<Kelas> kelasList = kelasService.getAllKelas();
        if (kelasList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Kelas"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                kelasList
            );
        }
    }

    @PostMapping("/addKelas")
    public ResponseEntity<?> addKelas(@Valid @RequestBody Kelas kelas) {
        try {
            Kelas newKelas = kelasService.addKelas(kelas);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.CREATED, 
                newKelas
            );
        } catch (DuplicateResourceException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.CONFLICT, 
                e.getMessage()
            );
        }
    }

    @PutMapping("/updateKelas/{id}")
    public ResponseEntity<?> updateKelas(@PathVariable Integer id, @Valid @RequestBody Kelas kelas) {
        try {
            Kelas updatedKelas = kelasService.updateKelas(id, kelas);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                updatedKelas
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }


    @DeleteMapping("/deleteKelasById/{id}")
    public ResponseEntity<?> deleteKelasById(@PathVariable Integer id) {
        try {
            Kelas deletedKelas = kelasService.deleteKelasById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                deletedKelas
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}
