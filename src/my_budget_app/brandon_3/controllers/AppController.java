package my_budget_app.brandon_3.controllers;

import my_budget_app.brandon_3.pojos.User;
import my_budget_app.brandon_3.utils.UserInputUtils;

import java.util.Scanner;

public class AppController {

    public static void runApp(){
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
                    System.out.println("What would you like to do?");
                    System.out.println("1) create a new account?");
                    System.out.println("2) try another email?");

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
