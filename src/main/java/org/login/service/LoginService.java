package org.login.service;

import org.login.dto.LoginDTO;

public interface LoginService {

    public boolean login(LoginDTO loginDTO);

    public void updatePassword(LoginDTO loginDTO);
}
