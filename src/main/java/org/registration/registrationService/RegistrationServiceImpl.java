package org.registration.registrationService;

import org.registration.regisstrationController.RegistrationController;
import org.registration.registarationDTO.RegistrationDTO;
import org.registration.registrationRepository.RegistrationRepository;
import org.registration.registrationRepository.RegistrationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    @Qualifier("registrationRepositoryImpl")
    RegistrationRepository registrationRepository;

//    public RegistrationServiceImpl(RegistrationRepository registrationRepository){
//        this.registrationRepository = registrationRepository;
//    }

    @Override
    public void takingDataFromController(RegistrationDTO registrationDTO){
        registrationRepository.saveDataToDatabase(registrationDTO);
    }


}
