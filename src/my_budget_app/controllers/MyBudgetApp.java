package my_budget_app.controllers;

import java.sql.SQLException;

import static my_budget_app.controllers.LogInAndMenus.logInProcedure;

/**
 * the main method to run the program
 */
public class MyBudgetApp {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to \"MyBudget\"!  Please select from the following options:");
        logInProcedure();

    }
}
