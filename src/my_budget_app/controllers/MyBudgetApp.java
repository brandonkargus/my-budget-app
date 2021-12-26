package my_budget_app.controllers;

import static my_budget_app.controllers.LogInAndMenus.logInProcedure;

/**
 * class where the main method lives
 */
public class MyBudgetApp {

    /**
     * main method to run the program, using a print-out line, and the logInProcedure() method
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to \"my-budget-app\"!  Please select from the following options:");
        logInProcedure();

    }
}
