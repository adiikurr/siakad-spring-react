package com.project.siakad.controller;

import java.util.List;
import java.util.Map;

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

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Siswa;
import com.project.siakad.model.ApiResponse;
import com.project.siakad.service.SiswaService;

@Controller
@RequestMapping("api/siswa")
public class SiswaController {
    @Autowired private SiswaService siswaService;

    @GetMapping("/getSiswaById/{id}")
    public ResponseEntity<?> getSiswaById(@PathVariable Integer id) {
        try {
            Siswa siswa = siswaService.getSiswaById(id);
            return ResponseEntity.ok(siswa);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    
    @GetMapping("/getAllSiswa")
    public ResponseEntity<?> getAllSiswa () {
        try {
            List<Siswa> siswaList = siswaService.getAllSiswa();
            if (siswaList.isEmpty()) {
                ApiResponse response = new ApiResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.name(),
                    Map.of("general", new String[]{"No data found for List Siswa"})
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok(siswaList);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/addSiswa")
    public ResponseEntity<?> addSiswa(@Valid @RequestBody Siswa siswa) {
        try {
            Siswa newSiswa = siswaService.addSiswa(siswa);
            return ResponseEntity.ok(newSiswa);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/updateSiswa/{id}")
    public ResponseEntity<?> updateSiswa(@PathVariable Integer id, @Valid @RequestBody Siswa siswa) {
        try {
            Siswa updatedSiswa = siswaService.updateSiswa(id, siswa);
            return ResponseEntity.ok(updatedSiswa);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("/deleteSiswaById/{id}")
    public ResponseEntity<?> deleteSiswaById(@PathVariable Integer id) {
        try {
            Siswa deletedSiswa = siswaService.deleteSiswaById(id);
            return ResponseEntity.ok(deletedSiswa);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
