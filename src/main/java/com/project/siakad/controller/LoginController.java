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
import com.project.siakad.model.Kelas;
import com.project.siakad.model.Session;
import com.project.siakad.model.Siswa;
import com.project.siakad.model.Users;
import com.project.siakad.service.LoginLogoutService;
import com.project.siakad.service.SiswaService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/login")
public class LoginController {
    @Autowired private LoginLogoutService loginLogoutService;

    @PostMapping("/guru")
    public ResponseEntity<?> loginGuru(@Valid @RequestBody Users users) {
        try {
            Session loginGuruUsers = loginLogoutService.LoginGuru(users);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                loginGuruUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}