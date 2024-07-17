package org.login.repository;

import org.login.dto.LoginDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl2 implements LoginRepository {
    @Override
    public LoginDTO getUserInfoFromUsername(LoginDTO loginDTOFromServiceLayer){
        return new LoginDTO("dummyname", "dummyPassword");
    }

    public void updatePasswordUsingUsername(LoginDTO loginDTO){
        System.out.println("dummy testing");

    }
}
