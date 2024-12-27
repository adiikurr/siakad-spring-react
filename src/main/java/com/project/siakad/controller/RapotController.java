package com.project.siakad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Rapot;
import com.project.siakad.service.RapotService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/rapot")
public class RapotController {
    @Autowired private RapotService rapotService;

    @GetMapping("/getRapotById/{id}")
    public ResponseEntity<?> getRapotById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Rapot rapot = rapotService.getRapotById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                rapot
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllRapot")
    public ResponseEntity<?> getAllRapot (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        List<Rapot> rapotList = rapotService.getAllRapot();
        if (rapotList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Rapot"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                rapotList
            );
        }
    }
}