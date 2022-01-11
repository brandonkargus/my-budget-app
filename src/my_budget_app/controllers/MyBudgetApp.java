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

        runApp();     //database is already populated with 3 sample users...if you don't wish to create a new user, you can use one of the following emails to access data and view printouts...pickle@gmail.com for "Peter Pickle", straw@codingnomads.co for "Sarah Strawberry", raisin@hotmail.com for "Rasheed Raisin"
    }
}
