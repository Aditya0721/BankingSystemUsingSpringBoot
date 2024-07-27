package org.login.repository;

import org.login.dto.LoginDTO;

public interface LoginRepository {

    //here we initialized methods, implemented in implementation classes and called this methods in  service implementation class.
    //passing loginDTO objects that are from service layer
    public LoginDTO getUserInfoFromUsername(LoginDTO loginDTOFromServiceLayer);
    public void updatePasswordUsingUsername(LoginDTO loginDTO);
}
