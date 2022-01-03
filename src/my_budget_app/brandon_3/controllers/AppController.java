package my_budget_app.brandon_3.controllers;

import my_budget_app.brandon_3.models.User;
import my_budget_app.brandon_3.utils.UserInputUtils;

import java.sql.SQLException;

public class AppController {

    public static void runApp() throws SQLException, ClassNotFoundException {
        AppController app = new AppController();
        UserController userController = new UserController();
        userController.welcomeUser();
        int response = app.printMainMenu();

        if (response == 2){
            System.out.println("Goodbye! :)");
            return;
        }
        User user = null;

        if(response == 1){

            while (true){
                user = userController.logInUser();

                if(user == null){
                    System.out.println("What would you like to do? (enter 1 or 2)");
                    System.out.println("1) Create a new account:");
                    System.out.println("2) Re-enter email:");

                    response = UserInputUtils.getValidIntInput(2);

                    if(response == 1){
                        user = userController.createNewUser();


                    } else {
                        continue;
                    }
                }
                break;
            }
        }
        userController.loadUserMenu(user);

    }

    private int printMainMenu() {
        System.out.println("1) LOG IN");
        System.out.println("2) EXIT");

        return UserInputUtils.getValidIntInput(2);
    }


}
