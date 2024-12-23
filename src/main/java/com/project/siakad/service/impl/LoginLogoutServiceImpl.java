package com.project.siakad.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Session;
import com.project.siakad.model.Users;
import com.project.siakad.repository.SessionRepo;
import com.project.siakad.repository.UsersRepo;
import com.project.siakad.service.LoginLogoutService;

@Service
public class LoginLogoutServiceImpl implements LoginLogoutService {
    @Autowired private SessionRepo sessionRepo;
    @Autowired private UsersRepo usersRepo;

    @Override
    public Session LoginOperator (Users users) {
        Optional<Users> user = usersRepo.findByUsername(users.getUsername());
        
        if(user.isEmpty()) {
            throw new ResourceNotFoundException("Username not found");
        }
        Users existingUsers = user.get();
        Optional<Session> opt = sessionRepo.findById(existingUsers.getUser_id());

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
			newSession.setRole("Operator");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = "operator_" + uuid.toString().split("-")[0];
			
			newSession.setToken(token);
			
			return sessionRepo.save(newSession);
		}
		else {
			throw new ResourceNotFoundException("tes");
		}
    }

    @Override
    public Session LoginGuru (Users users) {
        Optional<Users> user = usersRepo.findByUsername(users.getUsername());
        
        if(user.isEmpty()) {
            throw new ResourceNotFoundException("Username not found");
        }
        Users existingUsers = user.get();
        Optional<Session> opt = sessionRepo.findById(existingUsers.getUser_id());

        if (opt.isPresent()){
            Session sessionUser = opt.get();

            if (sessionUser.getSessionEndTime().isBefore(LocalDateTime.now())) {
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

    @Override
    public Session LoginSiswa (Users users) {
        Optional<Users> user = usersRepo.findByUsername(users.getUsername());
        
        if(user.isEmpty()) {
            throw new ResourceNotFoundException("Username not found");
        }
        Users existingUsers = user.get();
        Optional<Session> opt = sessionRepo.findById(existingUsers.getUser_id());

        if (opt.isPresent()){
            Session sessionUser = opt.get();

            if (sessionUser.getSessionEndTime().isBefore(LocalDateTime.now())) {
                sessionRepo.delete(sessionUser);
            } else {
                throw new ResourceNotFoundException("tes");
            }
        }

        if(existingUsers.getPassword().equals(users.getPassword())) {
		
			Session newSession = new Session();
			
			newSession.setUser_id(existingUsers.getUser_id());
			newSession.setRole("Siswa");
			newSession.setSessionEndTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = "siswa_" + uuid.toString().split("-")[0];
			
			newSession.setToken(token);
			
			return sessionRepo.save(newSession);
		}
		else {
			throw new ResourceNotFoundException("tes");
		}
    }

    @Override
	public Session logoutOperator(Session sessionToken) {
		
		String token = sessionToken.getToken();
		
		checkTokenStatus(token);
		
		Optional<Session> opt = sessionRepo.findByToken(token);
		
		if(!opt.isPresent())
        throw new ResourceNotFoundException("tes");
		
		Session session = opt.get();
		
		sessionRepo.delete(session);
		
		// sessionToken.setMessage("Logged out sucessfully.");
		
		return sessionToken;
	}
    
    @Override
	public Session logoutGuru(Session sessionToken) {
		
		String token = sessionToken.getToken();
		
		checkTokenStatus(token);
		
		Optional<Session> opt = sessionRepo.findByToken(token);
		
		if(!opt.isPresent())
        throw new ResourceNotFoundException("tes");
		
		Session session = opt.get();
		
		sessionRepo.delete(session);
		
		// sessionToken.setMessage("Logged out sucessfully.");
		
		return sessionToken;
	}
    
    @Override
	public Session logoutSiswa(Session sessionToken) {
		
		String token = sessionToken.getToken();
		
		checkTokenStatus(token);
		
		Optional<Session> opt = sessionRepo.findByToken(token);
		
		if(!opt.isPresent())
        throw new ResourceNotFoundException("tes");
		
		Session session = opt.get();
		
		sessionRepo.delete(session);
		
		// sessionToken.setMessage("Logged out sucessfully.");
		
		return sessionToken;
	}
	
	@Override
	public void checkTokenStatus(String token) {
		
		Optional<Session> opt = sessionRepo.findByToken(token);
		
		if(opt.isPresent()) {
			Session session = opt.get();
			LocalDateTime endTime = session.getSessionEndTime();
			boolean flag = false;
			if(endTime.isBefore(LocalDateTime.now())) {
				sessionRepo.delete(session);
				flag = true;
			}
			
			deleteExpiredTokens();
			if(flag)
            throw new ResourceNotFoundException("tes");
		}
		else {
			throw new ResourceNotFoundException("tes");
		}
		
	}
    
	@Override
	public void deleteExpiredTokens() {
		
		System.out.println("Inside delete tokens");
		
		List<Session> users = sessionRepo.findAll();
		
		System.out.println(users);
		
		if(users.size() > 0) {
			for(Session user:users) {
				System.out.println(user.getUser_id());
				LocalDateTime endTime = user.getSessionEndTime();
				if(endTime.isBefore(LocalDateTime.now())) {
					System.out.println(user.getUser_id());
					sessionRepo.delete(user);
				}
			}
		}
	}
}
