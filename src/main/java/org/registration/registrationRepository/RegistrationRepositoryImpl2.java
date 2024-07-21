package org.registration.registrationRepository;

import org.registration.registarationDTO.RegistrationDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepositoryImpl2 implements RegistrationRepository{

    @Override
    public void saveDataToDatabase(RegistrationDTO registrationDTO){
        System.out.println("This is registration repository implementation 2");
    }
}
