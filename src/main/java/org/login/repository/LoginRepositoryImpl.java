package org.login.repository;

import org.login.dto.LoginDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public LoginDTO getUserInfoFromUsername(LoginDTO loginDTOFromServiceLayer){

        Map<String, String> database = new HashMap<String, String>();

        database.put("Aditya", "Aditya123");
        database.put("Rajan", "Rajan123");
        database.put("Tanuja", "Tanuja123");

        //implement rest of the implementaion
        String userName = loginDTOFromServiceLayer.getUsername();

        String password = database.get(userName);

        LoginDTO loginDTOFromPersistenceLayer = new LoginDTO(userName, password);

        return loginDTOFromPersistenceLayer;
    }

    public void updatePasswordUsingUsername(LoginDTO loginDTO){
        Map<String, String> database = new HashMap<String, String>();

        database.put("Aditya", "Aditya123");
        database.put("Rajan", "Rajan123");
        database.put("Tanuja", "Tanuja123");
        System.out.println("database before update");
        System.out.println(Arrays.asList(database));

        String newPassword = loginDTO.getPassword();
        String userName = loginDTO.getUsername();
        database.put(userName, newPassword);
        System.out.println("database after update");
        System.out.println(Arrays.asList(database));

    }
}
