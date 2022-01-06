package my_budget_app.controllers;

import my_budget_app.models.User;
import my_budget_app.utils.UserInputUtils;

import java.sql.SQLException;

/**
 * class containing methods used to run app
 */

public class AppController {

    /**
     * called from the bootstrapping method, provides most functionality for program utilizing calls to various methods
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void runApp() throws SQLException, ClassNotFoundException {
        AppController app = new AppController();
        UserController userController = new UserController();

        userController.welcomeUser();
        int response = app.printMainMenu();

        if (response == 2) {
            System.out.println("Goodbye! :)");
            return;
        }

        User user;
        do {
            user = userController.logInUser();
            if (user == null) {
                System.out.println("What would you like to do? (enter 1 or 2)");
                System.out.println("1) Create a new account:");
                System.out.println("2) Re-enter email:");
                response = UserInputUtils.getValidIntInput(2);
                if (response == 1) {
                    user = userController.createNewUser();
                }
            }
        } while (user == null);

        userController.loadUserMenu(user);
    }

    /**
     * prints the menu and calls getValidIntInput() method for validation
     *
     * @return
     */
    private int printMainMenu() {
        System.out.println("1) LOG IN");
        System.out.println("2) EXIT");

        return UserInputUtils.getValidIntInput(2);
    }
}
