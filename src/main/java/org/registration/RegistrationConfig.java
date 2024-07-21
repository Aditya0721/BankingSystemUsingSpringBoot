package org.registration;

import org.registration.regisstrationController.RegistrationController;
import org.registration.registrationRepository.RegistrationRepository;
import org.registration.registrationRepository.RegistrationRepositoryImpl;
import org.registration.registrationRepository.RegistrationRepositoryImpl2;
import org.registration.registrationService.RegistrationService;
import org.registration.registrationService.RegistrationServiceImpl;
import org.registration.registrationService.RegistrationServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RegistrationConfig {

//    @Bean
//    public RegistrationRepository registrationRepository(){
//        return new RegistrationRepositoryImpl();
//    }
//
//    @Bean
//    public RegistrationRepository registrationRepository1(){
//        return new RegistrationRepositoryImpl2();
//    }
//
//    @Bean
//    public RegistrationService registrationService(){
//        return new RegistrationServiceImpl(registrationRepository());
//    }
//
//    @Bean
//    public RegistrationService registrationService1(){
//        return new RegistrationServiceImpl2(registrationRepository1());
//    }
//
//    @Bean
//    public RegistrationController registrationController(){
//        return new RegistrationController(registrationService());
//    }
//
//    @Bean
//    public RegistrationController registrationController1(){
//        return new RegistrationController(registrationService1());
//    }

}
