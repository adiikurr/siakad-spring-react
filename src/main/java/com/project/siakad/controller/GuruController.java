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
import com.project.siakad.model.Guru;
import com.project.siakad.model.ApiResponse;
import com.project.siakad.service.GuruService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/guru")
public class GuruController {
    @Autowired private GuruService guruService;

    @GetMapping("/getGuruById/{id}")
    public ResponseEntity<?> getGuruById(@PathVariable Integer id) {
        try {
            Guru guru = guruService.getGuruById(id);
            return ResponseUtil.generateSuccessResponse(HttpStatus.OK, guru);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    
    @GetMapping("/getAllGuru")
    public ResponseEntity<?> getAllGuru () {
        try {
            List<Guru> guruList = guruService.getAllGuru();
            if (guruList.isEmpty()) {
                ApiResponse response = new ApiResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.name(),
                    Map.of("general", new String[]{"No data found for List Guru"})
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok(guruList);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/addGuru")
    public ResponseEntity<?> addGuru(@Valid @RequestBody Guru guru) {
        try {
            Guru newGuru = guruService.addGuru(guru);
            return ResponseEntity.ok(newGuru);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/updateGuru/{id}")
    public ResponseEntity<?> updateGuru(@PathVariable Integer id, @Valid @RequestBody Guru guru) {
        try {
            Guru updatedGuru = guruService.updateGuru(id, guru);
            return ResponseEntity.ok(updatedGuru);
        } catch (ResourceNotFoundException e) {
            ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                Map.of("general", new String[]{e.getMessage()})
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("/deleteGuruById/{id}")
    public ResponseEntity<?> deleteGuruById(@PathVariable Integer id) {
        try {
            Guru deletedGuru = guruService.deleteGuruById(id);
            return ResponseEntity.ok(deletedGuru);
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
