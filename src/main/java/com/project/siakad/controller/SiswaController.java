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
import com.project.siakad.model.Siswa;
import com.project.siakad.service.SiswaService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/siswa")
public class SiswaController {
    @Autowired private SiswaService siswaService;

    @GetMapping("/getSiswaById/{id}")
    public ResponseEntity<?> getSiswaById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Siswa siswa = siswaService.getSiswaById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                siswa
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllSiswa")
    public ResponseEntity<?> getAllSiswa (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        List<Siswa> siswaList = siswaService.getAllSiswa();
        if (siswaList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Siswa"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                siswaList
            );
        }
    }

    @PostMapping("/addSiswa")
    public ResponseEntity<?> addSiswa(@Valid @RequestBody Siswa siswa, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Siswa newSiswa = siswaService.addSiswa(siswa);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.CREATED, 
                newSiswa
            );
        } catch (DuplicateResourceException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.CONFLICT, 
                e.getMessage()
            );
        }
    }

    @PutMapping("/updateSiswa/{id}")
    public ResponseEntity<?> updateSiswa(@PathVariable Integer id, @Valid @RequestBody Siswa siswa, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Siswa updatedSiswa = siswaService.updateSiswa(id, siswa);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                updatedSiswa
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }


    @DeleteMapping("/deleteSiswaById/{id}")
    public ResponseEntity<?> deleteSiswaById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Siswa deletedSiswa = siswaService.deleteSiswaById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                deletedSiswa
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}
