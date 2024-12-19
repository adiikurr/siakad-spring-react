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

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Siswa;
import com.project.siakad.service.SiswaService;

@Controller
@RequestMapping("api/siswa")
public class SiswaController {
    @Autowired private SiswaService siswaService;

    @GetMapping("/getSiswaById/{id}")
    public ResponseEntity<Siswa> getSiswaById(@PathVariable Integer id) {
        Siswa siswa = siswaService.getSiswaById(id);
        return ResponseEntity.ok(siswa);
    }
    
    @GetMapping("/getAllSiswa")
    public ResponseEntity<List<Siswa>> getAllSiswa () {
        List<Siswa> siswa = siswaService.getAllSiswa();
        return ResponseEntity.ok(siswa);
    }

    @PostMapping("/addSiswa")
    public ResponseEntity<Siswa> addSiswa(@Valid @RequestBody Siswa siswa) {
        Siswa newsiswa = siswaService.addSiswa(siswa);

        return ResponseEntity.status(HttpStatus.CREATED).body(newsiswa);
    }

    @PutMapping("/updateSiswa/{id}")
    public ResponseEntity<?> updateSiswa(@PathVariable Integer id, @RequestBody Siswa siswa) {
        try {
            Siswa updatedSiswa = siswaService.updateSiswa(id, siswa);
            return ResponseEntity.ok(updatedSiswa);
        }  catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteSiswaById/{id}")
    public ResponseEntity<?> deleteSiswaById(@PathVariable Integer id) {
        try {
            Siswa deletedSiswa = siswaService.deleteSiswaById(id);
            return ResponseEntity.ok(deletedSiswa);
        }  catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}