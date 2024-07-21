package org.registration.registrationService;

import org.registration.registarationDTO.RegistrationDTO;
import org.registration.registrationRepository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl2 implements RegistrationService{
    @Autowired
    @Qualifier("registrationRepositoryImpl2")
    RegistrationRepository registrationRepository;

//    public RegistrationServiceImpl2(RegistrationRepository registrationRepository1){
//        this.registrationRepository = registrationRepository1;
//    }
    @Override
    public void takingDataFromController(RegistrationDTO registrationDTO){
        registrationRepository.saveDataToDatabase(registrationDTO);

    }
}
