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
import com.project.siakad.model.Guru;
import com.project.siakad.service.GuruService;

@Controller
@RequestMapping("api/guru")
public class GuruController {
    @Autowired private GuruService guruService;

    @GetMapping("/getGuruById/{id}")
    public ResponseEntity<Guru> getGuruById(@PathVariable Integer id) {
        Guru guru = guruService.getGuruById(id);
        return ResponseEntity.ok(guru);
    }
    
    @GetMapping("/getAllGuru")
    public ResponseEntity<List<Guru>> getAllGuru () {
        List<Guru> guru = guruService.getAllGuru();
        return ResponseEntity.ok(guru);
    }

    @PostMapping("/addGuru")
    public ResponseEntity<Guru> addGuru(@Valid @RequestBody Guru guru) {
        Guru newguru = guruService.addGuru(guru);

        return ResponseEntity.status(HttpStatus.CREATED).body(newguru);
    }

    @PutMapping("/updateGuru/{id}")
    public ResponseEntity<?> updateGuru(@PathVariable Integer id, @RequestBody Guru guru) {
        try {
            Guru updatedGuru = guruService.updateGuru(id, guru);
            return ResponseEntity.ok(updatedGuru);
        }  catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteGuruById/{id}")
    public ResponseEntity<?> deleteGuruById(@PathVariable Integer id) {
        try {
            Guru deletedGuru = guruService.deleteGuruById(id);
            return ResponseEntity.ok(deletedGuru);
        }  catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
