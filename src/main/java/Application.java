import org.login.controller.LogInController;
import org.login.dto.LoginDTO;

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

        LoginDTO loginDTO = new LoginDTO(name, password);
        LogInController logInController = new LogInController();

        logInController.logIn(loginDTO);
        logInController.updatePassword(new LoginDTO(name, updatePassword));
    }
}
