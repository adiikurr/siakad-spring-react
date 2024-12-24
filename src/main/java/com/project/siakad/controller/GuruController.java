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
import com.project.siakad.model.Guru;
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
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                guru
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllGuru")
    public ResponseEntity<?> getAllGuru () {
        List<Guru> guruList = guruService.getAllGuru();
        if (guruList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Guru"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                guruList
            );
        }
    }

    @PostMapping("/addGuru")
    public ResponseEntity<?> addGuru(@Valid @RequestBody Guru guru) {
        try {
            Guru newGuru = guruService.addGuru(guru);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.CREATED, 
                newGuru
            );
        } catch (DuplicateResourceException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.CONFLICT, 
                e.getMessage()
            );
        }
    }

    @PutMapping("/updateGuru/{id}")
    public ResponseEntity<?> updateGuru(@PathVariable Integer id, @Valid @RequestBody Guru guru) {
        try {
            Guru updatedGuru = guruService.updateGuru(id, guru);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                updatedGuru
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }


    @DeleteMapping("/deleteGuruById/{id}")
    public ResponseEntity<?> deleteGuruById(@PathVariable Integer id) {
        try {
            Guru deletedGuru = guruService.deleteGuruById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                deletedGuru
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}
