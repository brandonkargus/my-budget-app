package my_budget_app.controllers;

import java.sql.SQLException;
import java.util.Scanner;

public class MyBudgetApp {
    static Scanner scanner = new Scanner(System.in);

    public static void startUp() throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to your Budgeting App!");
        System.out.println("______________________________");
        System.out.println("Please select from the following menu options:");
        System.out.println("1) New User");
        System.out.println("2) Existing User");
        System.out.println("3) Exit");
        int response = scanner.nextInt();
        while (response < 1 || response > 3) {
            System.out.println("Invalid response, please select from the options provided: ");
            response = scanner.nextInt();
        }
        if (response == 1) {
            NewUserPrompts.infoEntry();
        } else if (response == 2) {
            MainMenuPrompts.mainMenu();
        } else {
            System.out.println("Good Bye!");
            scanner.close();
        }
    }

    public static void main(String[] args) throws Exception {
        startUp();

    }
}
