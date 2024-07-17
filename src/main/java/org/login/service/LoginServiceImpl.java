package org.login.service;

import org.login.dto.LoginDTO;
import org.login.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    /*
    *1. get data from controller class
    *2. send the data to repository and get back the data from persistance layer
    *3. use the data for your business logic
    *4. rerun it back to the controller class
    */
    @Autowired
    @Qualifier("loginRepositoryImpl2")
    private LoginRepository loginRepository;

//    @Autowired
//    @Qualifier("loginRepositoryImpl2")
//    public void setLoginRepository(LoginRepository loginRepository) {
//        this.loginRepository = loginRepository;
//    }

//    @Autowired
//    public LoginServiceImpl(@Qualifier("loginRepositoryImpl2")LoginRepository loginRepository) {
//        this.loginRepository = loginRepository;
//    }


    @Override
    public boolean login(LoginDTO loginDTOFromController) {

        // service layer to get the data from database will take help of a method defined in one of the classes of a persistance layer. because persistance layer can only talk with database

        LoginDTO loginDTOFromPersistence = loginRepository.getUserInfoFromUsername(loginDTOFromController);

//        loginRepository2.getUserInfoFromUsername(loginDTOFromController);

        //business logic
        if(loginDTOFromPersistence.getPassword().equals(loginDTOFromController.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void updatePassword(LoginDTO loginDTO){
        loginRepository.updatePasswordUsingUsername(loginDTO);
    }

}
