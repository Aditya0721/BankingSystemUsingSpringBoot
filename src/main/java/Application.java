import org.login.LoginConfig;
import org.login.controller.LogInController;
import org.login.dto.LoginDTO;
import org.registration.RegistrationConfig;
import org.registration.regisstrationController.RegistrationController;
import org.registration.registarationDTO.Gender;
import org.registration.registarationDTO.RegistrationDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        RegistrationDTO registrationDTO = new RegistrationDTO();

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
        switch(gender){
            case 'M': registrationDTO.setGender(Gender.MALE);
            break;
            case 'F': registrationDTO.setGender(Gender.FEMALE);
        }
        System.out.println(registrationDTO);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Update your new password");
        String updatePassword = sc.nextLine();

        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LoginConfig.class, RegistrationConfig.class);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Environment env = applicationContext.getEnvironment();
        //JAVA BASED CONFIGURATION
//        private LoginService loginService =  applicationContext.getBean("loginServiceImpl", LoginServiceImpl.class);

//        private LoginRepository loginRepository = (LoginRepository) applicationContext.getBean("loginRepositoryImpl2");

        LoginDTO loginDTO = new LoginDTO(name, password);


        LogInController logInController = applicationContext.getBean(LogInController.class);

        logInController.logIn(loginDTO);
        logInController.updatePassword(new LoginDTO(name, updatePassword));


        RegistrationController registrationController = (RegistrationController) applicationContext.getBean("registrationController");
        //RegistrationController registrationController1 = (RegistrationController) applicationContext.getBean("registrationController1");
////        RegistrationController registrationController1 = applicationContext.getBean(RegistrationController.class);
//        RegistrationController registrationController2 = applicationContext.getBean("registrationController", RegistrationController.class);
        registrationController.getUserDataFromUI(registrationDTO);
        registrationController.getUserData(registrationDTO);
    }
}
