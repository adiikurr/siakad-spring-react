package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Users;

public interface UsersService {
    public Users getUsersById(Integer usersId);

    public List<Users> getAllUsers();

    public Users addUsers (Users users);

    public Users updateUsers (Integer id, Users users);
    
    public Users deleteUsersById (Integer id);
}
