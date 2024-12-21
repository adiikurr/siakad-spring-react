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
import com.project.siakad.model.Ruang;
import com.project.siakad.service.RuangService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/ruang")
public class RuangController {
    @Autowired private RuangService ruangService;

    @GetMapping("/getRuangById/{id}")
    public ResponseEntity<?> getRuangById(@PathVariable Integer id) {
        try {
            Ruang ruang = ruangService.getRuangById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                ruang
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllRuang")
    public ResponseEntity<?> getAllRuang () {
        List<Ruang> ruangList = ruangService.getAllRuang();
        if (ruangList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Ruang"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                ruangList
            );
        }
    }

    @PostMapping("/addRuang")
    public ResponseEntity<?> addRuang(@Valid @RequestBody Ruang ruang) {
        try {
            Ruang newRuang = ruangService.addRuang(ruang);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                newRuang
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }

    @PutMapping("/updateRuang/{id}")
    public ResponseEntity<?> updateRuang(@PathVariable Integer id, @Valid @RequestBody Ruang ruang) {
        try {
            Ruang updatedRuang = ruangService.updateRuang(id, ruang);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                updatedRuang
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }


    @DeleteMapping("/deleteRuangById/{id}")
    public ResponseEntity<?> deleteRuangById(@PathVariable Integer id) {
        try {
            Ruang deletedRuang = ruangService.deleteRuangById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                deletedRuang
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}
