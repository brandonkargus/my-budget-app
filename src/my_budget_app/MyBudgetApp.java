package my_budget_app;

import my_budget_app.brandon_3.controllers.AppController;

import static my_budget_app.brandon_2.controllers.LogInAndMenus.logInProcedure;

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
        //logInProcedure();
        AppController.runApp();
    }
}
