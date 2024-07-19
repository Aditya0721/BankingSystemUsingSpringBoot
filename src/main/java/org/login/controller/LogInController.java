package org.login.controller;

import org.login.ApplicationConfig;
import org.login.dto.LoginDTO;
import org.login.repository.LoginRepository;
import org.login.repository.LoginRepositoryImpl;
import org.login.repository.LoginRepositoryImpl2;
import org.login.service.LoginService;
import org.login.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;


@Controller
public class LogInController {
    //    private LoginService loginService = new LoginServiceImpl(new LoginRepositoryImpl());
//
    private File file = new File("src/main/java/org/login/messages.properties");

    private String filePath = file.getAbsolutePath();

    private FileReader fileReader;

    {
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties prop = new Properties();

    @Autowired
    private LoginService loginService;

//    private LoginRepository loginRepository = applicationContext.getBean("customerLoginRepository", LoginRepositoryImpl2.class);

    public void logIn(LoginDTO loginDTOFromUserInterface) {
        //call to the service class method for the login process
        // controller will use a method defined in one of the classes of service layer to authenticate user

        try {
            this.prop.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.filePath);

        boolean isAuthenticated = loginService.login(loginDTOFromUserInterface);
        if (isAuthenticated) {
            System.out.println(prop.getProperty("login.success.message"));
        } else {
            System.out.println(prop.getProperty("login.failure.message"));
        }
    }

    public void updatePassword(LoginDTO loginDTO) {

        loginService.updatePassword(loginDTO);
    }
}
