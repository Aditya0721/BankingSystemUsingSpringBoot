package org.login.controller;

import org.login.ApplicationConfig;
import org.login.dto.LoginDTO;
import org.login.repository.LoginRepository;
import org.login.repository.LoginRepositoryImpl;
import org.login.repository.LoginRepositoryImpl2;
import org.login.service.LoginService;
import org.login.service.LoginServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class LogInController {
//    private LoginService loginService = new LoginServiceImpl(new LoginRepositoryImpl());

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    //JAVA BASED CONFIGURATION
    private LoginService loginService =  applicationContext.getBean("loginServiceImpl", LoginServiceImpl.class);

    private LoginRepository loginRepository = (LoginRepository) applicationContext.getBean("loginRepositoryImpl2");

//    private LoginRepository loginRepository = applicationContext.getBean("customerLoginRepository", LoginRepositoryImpl2.class);

    public void logIn(LoginDTO loginDTOFromUserInterface) {
        //call to the service class method for the login process
        // controller will use a method defined in one of the classes of service layer to authenticate user

        boolean isAuthenticated = loginService.login(loginDTOFromUserInterface);
        if(isAuthenticated) {
            System.out.println("Login successful");
        }
        else{
            System.out.println("Login failed");
        }
    }

    public void updatePassword(LoginDTO loginDTO){

        loginService.updatePassword(loginDTO);
    }
}
