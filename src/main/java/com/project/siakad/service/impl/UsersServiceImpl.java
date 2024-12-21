package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Users;
import com.project.siakad.repository.UsersRepo;
import com.project.siakad.service.UsersService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired private UsersRepo UsersRepo;

    @Override
    public Users getUsersById(Integer usersId) {
        return UsersRepo.findById(usersId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Users not found with ID: " + usersId));
    }
    @Override
    public List<Users> getAllUsers(){
        return UsersRepo.findAll();
    }
    @Override
    public Users addUsers (Users users) {   
        users.setCreated_at(LocalDateTime.now());
        return UsersRepo.save(users);
    }
    @Override
    public Users updateUsers (Integer id, Users users) {
        Users existingUsers = UsersRepo.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Data Users not found with ID: " + id));
        
        existingUsers.setUsername(users.getUsername());
        existingUsers.setPassword(users.getPassword());
        existingUsers.setRole(users.getRole());
        existingUsers.setNip(users.getNip());
        existingUsers.setNo_induk(users.getNo_induk());
        existingUsers.setUpdated_at(LocalDateTime.now());

        return UsersRepo.save(existingUsers);
    }
    @Override
    public Users deleteUsersById (Integer id) {
        Users existingUsers = UsersRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Users not found with ID: " + id));

        UsersRepo.delete(existingUsers);
        return existingUsers;
    }
}
