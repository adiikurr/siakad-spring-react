package com.project.siakad.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.siakad.service.SiakadService;
import com.project.siakad.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/siakad")
public class SiakadController {
    @Autowired private SiakadService siakadService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Users> getDataById(@PathVariable Integer id) {
        Users siakad = siakadService.getDataById(id);
        return ResponseEntity.ok(siakad);
    }
    
    @GetMapping("/get")
    public ResponseEntity<List<Users>> getData () {
        List<Users> siakad = siakadService.getData();
        return ResponseEntity.ok(siakad);
    }

    @PostMapping("/add")
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
        Users newSiakad = siakadService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newSiakad);
    }
    
}
