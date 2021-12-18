package my_budget_app.controllers;

import my_budget_app.services.RunAccountBalances;
import my_budget_app.services.ViewSavingsGoals;
import my_budget_app.services.ViewStudentLoanTimeline;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenuPrompts {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() throws SQLException, ClassNotFoundException {

        System.out.println("Please select from the following menu options:");
        System.out.println("1) View Account Balances");
        System.out.println("2) View Savings Goal Track");
        System.out.println("3) View Student Loan Payment Timeline");
        System.out.println("4) Exit");
        int response = scanner.nextInt();
        while (response < 0 || response > 4) {
            System.out.println("Invalid response, please select from the options provided: ");
            response = scanner.nextInt();
        }
        if (response == 1) {
            RunAccountBalances runBalances = new RunAccountBalances();
            runBalances.getAccountBalances();
            System.out.println("-------------------------------------");
            System.out.println("Enter any key to return to main menu..");
            scanner.next();
            mainMenu();

        } else if (response == 2) {
            ViewSavingsGoals savings = new ViewSavingsGoals();
            savings.getSavingsTimeLine();
            System.out.println("----------------------------------");
            System.out.println("Enter any key to return to main menu");
            scanner.next();
            mainMenu();
        } else if (response == 3) {
            ViewStudentLoanTimeline viewTime = new ViewStudentLoanTimeline();
            viewTime.getStudentLoanTimeline();
            System.out.println("--------------------------------");
            System.out.println("Enter any key to return to main menu..");
            scanner.next();
            mainMenu();
        } else {
            System.out.println("Good Bye!");
            scanner.close();
        }

    }

}
