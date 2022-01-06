package my_budget_app.controllers;

import java.sql.SQLException;

import static my_budget_app.controllers.AppController.runApp;

/**
 * bootstrapping class where the main method lives
 */
public class MyBudgetApp {

    /**
     * bootstrapping method
     *
     * @param args
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        runApp();
    }
}
