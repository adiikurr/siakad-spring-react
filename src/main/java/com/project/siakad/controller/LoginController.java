package com.project.siakad.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Session;
import com.project.siakad.model.Users;
import com.project.siakad.service.LoginLogoutService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/auth")
public class LoginController {
    @Autowired private LoginLogoutService loginLogoutService;

    @PostMapping("login/operator")
    public ResponseEntity<?> loginOperator(@Valid @RequestBody Users users) {
        try {
            Session loginOperatorUsers = loginLogoutService.LoginOperator(users);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                loginOperatorUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }

    @PostMapping("login/guru")
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

    @PostMapping("login/siswa")
    public ResponseEntity<?> loginSiswa(@Valid @RequestBody Users users) {
        try {
            Session loginSiswaUsers = loginLogoutService.LoginSiswa(users);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                loginSiswaUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }

    @PostMapping("logout/operator")
    public ResponseEntity<?> logoutOperator(@Valid @RequestBody Session sessionToken) {
        try {
            Session logoutOperatorUsers = loginLogoutService.logoutOperator(sessionToken);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                logoutOperatorUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }

    @PostMapping("logout/guru")
    public ResponseEntity<?> logoutGuru(@Valid @RequestBody Session sessionToken) {
        try {
            Session logoutGuruUsers = loginLogoutService.logoutGuru(sessionToken);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                logoutGuruUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }

    @PostMapping("logout/siswa")
    public ResponseEntity<?> logoutSiswa(@Valid @RequestBody Session sessionToken) {
        try {
            Session logoutSiswaUsers = loginLogoutService.logoutSiswa(sessionToken);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                logoutSiswaUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}