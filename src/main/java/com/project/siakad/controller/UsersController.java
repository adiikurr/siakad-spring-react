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
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.siakad.exception.DuplicateResourceException;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Users;
import com.project.siakad.service.UsersService;
import com.project.siakad.util.ResponseUtil;

@Controller
@RequestMapping("api/users")
public class UsersController {
    @Autowired private UsersService usersService;

    @GetMapping("/getUsersById/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Users users = usersService.getUsersById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                users
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
    
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers (@RequestHeader("token") String token, @RequestHeader("role") String role) {
        List<Users> usersList = usersService.getAllUsers();
        if (usersList.isEmpty()) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                "No data found for List Users"
            );
        } else {
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                usersList
            );
        }
    }

    @PostMapping("/addUsers")
    public ResponseEntity<?> addUsers(@Valid @RequestBody Users users, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Users newUsers = usersService.addUsers(users);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.CREATED, 
                newUsers
            );
        } catch (DuplicateResourceException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.CONFLICT, 
                e.getMessage()
            );
        }
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<?> updateUsers(@PathVariable Integer id, @Valid @RequestBody Users users, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Users updatedUsers = usersService.updateUsers(id, users);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                updatedUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }


    @DeleteMapping("/deleteUsersById/{id}")
    public ResponseEntity<?> deleteUsersById(@PathVariable Integer id, @RequestHeader("token") String token, @RequestHeader("role") String role) {
        try {
            Users deletedUsers = usersService.deleteUsersById(id);
            return ResponseUtil.generateSuccessResponse(
                HttpStatus.OK, 
                deletedUsers
            );
        } catch (ResourceNotFoundException e) {
            return ResponseUtil.generateErrorResponse(
                HttpStatus.NOT_FOUND, 
                e.getMessage()
            );
        }
    }
}
