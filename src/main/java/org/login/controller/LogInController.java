package org.login.controller;

import org.login.dto.LoginDTO;
import org.login.exceptions.BankingSystemLoginException;
import org.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


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
// user will enter the username and password and storing those values in a loginDTO object
    //use this method in application class or userinterface
    public static void loginUI(LoginDTO loginDTO){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        loginDTO.setUsername(name);
        loginDTO.setPassword(password);
    }

//    private LoginRepository loginRepository = applicationContext.getBean("customerLoginRepository", LoginRepositoryImpl2.class);

    public void logIn(LoginDTO loginDTOFromUserInterface) throws BankingSystemLoginException {
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
            //System.out.println(prop.getProperty("login.failure.message"));
            throw new BankingSystemLoginException(prop.getProperty("login.failure.message"));

        }

    }

    //here we are calling the method of the login service and passing loginDTO object to that method
    public void updatePassword(LoginDTO loginDTO) {

        loginService.updatePassword(loginDTO);
    }
}
