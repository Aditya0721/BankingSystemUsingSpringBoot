import org.login.ApplicationConfig;
import org.login.controller.LogInController;
import org.login.dto.LoginDTO;
import org.login.repository.LoginRepository;
import org.login.service.LoginService;
import org.login.service.LoginServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Update your new password");
        String updatePassword = sc.nextLine();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Environment env = applicationContext.getEnvironment();
        //JAVA BASED CONFIGURATION
//        private LoginService loginService =  applicationContext.getBean("loginServiceImpl", LoginServiceImpl.class);

//        private LoginRepository loginRepository = (LoginRepository) applicationContext.getBean("loginRepositoryImpl2");

        LoginDTO loginDTO = new LoginDTO(name, password);

        LogInController logInController = applicationContext.getBean(LogInController.class);

        logInController.logIn(loginDTO);
        logInController.updatePassword(new LoginDTO(name, updatePassword));
    }
}
