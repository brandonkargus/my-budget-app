package my_budget_app.brandon_3.controllers;

import java.sql.SQLException;

/**
 * class where the main method lives
 */
public class MyBudgetApp {

    /**
     * main method to run the program, using a print-out line, and the logInProcedure() method
     * @param args
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AppController.runApp();
    }
}
