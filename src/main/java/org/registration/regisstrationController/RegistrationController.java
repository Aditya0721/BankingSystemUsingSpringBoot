package org.registration.regisstrationController;

import org.registration.registarationDTO.Gender;
import org.registration.registarationDTO.RegistrationDTO;
import org.registration.registrationService.RegistrationService;
import org.registration.registrationService.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class RegistrationController {
        @Autowired
        @Qualifier("registrationServiceImpl")
        RegistrationService registrationService;

        @Autowired
        @Qualifier("registrationServiceImpl2")
        RegistrationService registrationService1;

        @Autowired
        RegistrationDTO registrationDTO;
//        public RegistrationController(RegistrationService registrationService){
//            this.registrationService = registrationService;
//        }

        public void getUserInput(RegistrationDTO registrationDTO){
                try {
                        Scanner sc = new Scanner(System.in);

                        System.out.println("Enter your first name");
                        registrationDTO.setFirstName(sc.nextLine());

                        System.out.println("Enter the last name");
                        registrationDTO.setLastName(sc.nextLine());

                        System.out.println("Enter the Mobile Number");
                        registrationDTO.setMobileNumber(sc.nextLine());

                        System.out.println("Enter the address");
                        registrationDTO.setAddress(sc.nextLine());

                        System.out.println("Enter an email id");
                        registrationDTO.setEmailID(sc.nextLine());

                        System.out.println("Enter the gender : M for male and F for female");
                        char gender = sc.next().charAt(0);
                        switch (gender) {
                                case 'M':
                                        registrationDTO.setGender(Gender.MALE);
                                        break;
                                case 'F':
                                        registrationDTO.setGender(Gender.FEMALE);
                        }
//                        System.out.println(registrationDTO);
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                        this.getUserInput(registrationDTO);
                }
        }

        public void registration(RegistrationDTO registrationDTO) throws Exception {
                if(registrationDTO.validateMobileNumber(registrationDTO.getMobileNumber())){
                        registrationService.takingDataFromController(registrationDTO);
                }
                else{
                        throw new Exception("Your number is not as per the format please enter a valid number");
                }
        }

        public void getUserData(RegistrationDTO registrationDTO){
            registrationService1.takingDataFromController(registrationDTO);
        }

}
