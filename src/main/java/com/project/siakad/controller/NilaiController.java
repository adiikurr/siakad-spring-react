package com.project.siakad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Nilai;
import com.project.siakad.service.NilaiService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/nilai")
public class NilaiController {
    @Autowired private NilaiService nilaiService;

    @GetMapping("/getNilaiById/{id}")
    public ResponseEntity<?> getNilaiById(@PathVariable Integer id) {
        try {
            Nilai nilai = nilaiService.getNilaiById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                nilai
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllNilai")
    public ResponseEntity<?> getAllNilai () {
        List<Nilai> nilaiList = nilaiService.getAllNilai();
        if (nilaiList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Nilai"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                nilaiList
            );
        }
    }
}