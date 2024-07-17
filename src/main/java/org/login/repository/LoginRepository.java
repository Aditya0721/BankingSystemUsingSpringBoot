package org.login.repository;

import org.login.dto.LoginDTO;

public interface LoginRepository {

    public LoginDTO getUserInfoFromUsername(LoginDTO loginDTOFromServiceLayer);
    public void updatePasswordUsingUsername(LoginDTO loginDTO);
}
