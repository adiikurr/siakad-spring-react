package com.project.siakad.service;

import com.project.siakad.model.Session;
import com.project.siakad.model.Users;

public interface LoginLogoutService {
    public Session LoginOperator (Users users);
    
    public Session LoginGuru(Users users);

    public Session LoginSiswa (Users users);

    public Session logoutOperator(Session sessionToken);

    public Session logoutGuru(Session sessionToken);

    public Session logoutSiswa(Session sessionToken);

    public void checkTokenStatus(String token);

    public void deleteExpiredTokens();
}
