package org.registration.regisstrationController;

import org.registration.registarationDTO.RegistrationDTO;
import org.registration.registrationService.RegistrationService;
import org.registration.registrationService.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {
        @Autowired
        @Qualifier("registrationServiceImpl")
        RegistrationService registrationService;

        @Autowired
        @Qualifier("registrationServiceImpl2")
        RegistrationService registrationService1;

//        public RegistrationController(RegistrationService registrationService){
//            this.registrationService = registrationService;
//        }

        public void getUserDataFromUI(RegistrationDTO registrationDTO){
            registrationService.takingDataFromController(registrationDTO);
        }

        public void getUserData(RegistrationDTO registrationDTO){
            registrationService1.takingDataFromController(registrationDTO);
        }

}
