package org.registration.registrationRepository;

import org.registration.registarationDTO.RegistrationDTO;
import org.registration.registrationService.RegistrationService;
import org.registration.registrationService.RegistrationServiceImpl;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository{

    @Override
    public void saveDataToDatabase(RegistrationDTO registrationDTO){
        System.out.println("Saving customer details to the database");
    }
}
