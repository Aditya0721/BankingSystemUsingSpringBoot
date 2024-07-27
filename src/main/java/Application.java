import org.login.LoginConfig;
import org.login.controller.LogInController;
import org.login.dto.LoginDTO;
import org.login.exceptions.BankingSystemLoginException;
import org.registration.RegistrationConfig;
import org.registration.regisstrationController.RegistrationController;
import org.registration.registarationDTO.Gender;
import org.registration.registarationDTO.RegistrationDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Environment env = applicationContext.getEnvironment();
        LoginDTO loginDTO = applicationContext.getBean(LoginDTO.class);
        LogInController logInController = applicationContext.getBean(LogInController.class); // to call the method of loginController
        logInController.loginUI(loginDTO);
        try{
            logInController.logIn(loginDTO);
        }
        catch(BankingSystemLoginException be){
            System.out.println(be.getMessage());
        }

        RegistrationDTO registrationDTO = applicationContext.getBean(RegistrationDTO.class);
        RegistrationController registrationController = applicationContext.getBean(RegistrationController.class);

        registrationController.getUserInput(registrationDTO);

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter your number: ");
            Integer number = sc.nextInt();

            int b = number/0;

            System.out.println("User entered an Integer");
            int[] a = new int[10];
            a[10] = 12;



        }
        catch(ArithmeticException e){
            System.out.println("You are dividing by 0");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds");
        }
        catch(InputMismatchException e){
            System.out.println("You entered an invalid number");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("you have not entered an integer please enter an integer");
        }
        finally {
            System.out.println("This piece of block should be executed no matter what- called finally");
        }
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LoginConfig.class, RegistrationConfig.class);

        //JAVA BASED CONFIGURATION
//        private LoginService loginService =  applicationContext.getBean("loginServiceImpl", LoginServiceImpl.class);

//        private LoginRepository loginRepository = (LoginRepository) applicationContext.getBean("loginRepositoryImpl2");

//        RegistrationController registrationController = (RegistrationController) applicationContext.getBean("registrationController");
        //RegistrationController registrationController1 = (RegistrationController) applicationContext.getBean("registrationController1");
//        RegistrationController registrationController1 = applicationContext.getBean(RegistrationController.class);
//        RegistrationController registrationController2 = applicationContext.getBean("registrationController", RegistrationController.class);
        try{
            registrationController.registration(registrationDTO);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            registrationController.getUserData(registrationDTO);
        }

        //LoginDTO loginDTO = new LoginDTO();


        System.out.println("Update your new password");
        String updatePassword = sc.nextLine();
        logInController.updatePassword(new LoginDTO(loginDTO.getUsername(), updatePassword));
    }
}
