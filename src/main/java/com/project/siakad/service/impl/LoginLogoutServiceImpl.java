package com.project.siakad.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Guru;
import com.project.siakad.model.Session;
import com.project.siakad.model.Users;
import com.project.siakad.repository.GuruRepo;
import com.project.siakad.repository.SessionRepo;
import com.project.siakad.repository.UsersRepo;
import com.project.siakad.service.LoginLogoutService;

public class LoginLogoutServiceImpl implements LoginLogoutService {
    @Autowired private SessionRepo sessionRepo;
    @Autowired private UsersRepo usersRepo;

    @Override
    public Session LoginGuru (Users users) {
        Optional<Users> user = usersRepo.findByUsername(users.getUsername());
        
        if(user.isEmpty()) {
            throw new ResourceNotFoundException("Username not found");
        }
        Users existingUsers = user.get();
        Optional<Session> opt = sessionRepo.findByUserId(existingUsers.getUser_id());

        if (opt.isPresent()){
            Session sessionUser = opt.get();

            if (sessionUser.getSessionStartTime().isBefore(LocalDateTime.now())) {
                sessionRepo.delete(sessionUser);
            } else {
                throw new ResourceNotFoundException("tes");
            }
        }

        if(existingUsers.getPassword().equals(users.getPassword())) {
		
			Session newSession = new Session();
			
			newSession.setUser_id(existingUsers.getUser_id());
			newSession.setRole("Guru");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = "guru_" + uuid.toString().split("-")[0];
			
			newSession.setToken(token);
			
			return sessionRepo.save(newSession);
		}
		else {
			throw new ResourceNotFoundException("tes");
		}
    }
}
