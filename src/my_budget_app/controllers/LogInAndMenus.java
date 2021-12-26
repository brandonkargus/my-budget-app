package my_budget_app.controllers;

import my_budget_app.data.MySQLAccess;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogInAndMenus {
    public String email;
    static Scanner scanner = new Scanner(System.in);


    /**
     * method which funnels the user toward email entry, or quits application
     */
    public static void logInProcedure() {
        int response;
        try {
            System.out.println("1) LOG IN");
            System.out.println("2) EXIT");
            response = scanner.nextInt();
            while (response < 0 || response > 2) {
                System.out.println("Invalid entry, please type 1 or 2:");
                response = scanner.nextInt();
            }
            switch (response) {
                case 1:
                    scanner.nextLine();
                    emailEntryPrompt();
                    break;
                default:
                    System.out.println("Good Bye!");
            }
        } catch (InputMismatchException | SQLException | ClassNotFoundException e) {
            System.out.println("You must enter a valid number, please try again...");
            scanner.next();
            logInProcedure();
        }
    }

    /**
     * prompts for user to enter email - options are for demonstrative purposes, logInUser() called at end of method
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void emailEntryPrompt() throws SQLException, ClassNotFoundException {
        LogInAndMenus login = new LogInAndMenus();
        System.out.println("Please enter your EMAIL to LOG IN...");
        System.out.println();
        System.out.println("For the sake of this demonstration, you may select between these existing users:");
        System.out.println("Peter Pickle - (pickle@gmail.com)");
        System.out.println("Sarah Strawberry - (straw@codingnomads.co)");
        System.out.println("Rasheed Raisin - (raisin@hotmail.com)");
        System.out.println();
        System.out.println("Enter email:");
        login.logInUser();

    }

    /**
     * checks for potentially harmful characters to prevent Injection attack in SQL
     * @param email
     * @return
     */
    public boolean isValidEmail(String email) {
        if(email.contains("'"))
            return false;
        if(email.contains(";"))
            return false;
        return true;
    }

    /**
     * uses the isValidEmail() method, to ensure the email being entered is valid
     * @return
     */
    public String getValidEmail() {
        String email = scanner.nextLine();
        while(!isValidEmail(email)) {
            System.out.println("Invalid email, please try again");
            email = scanner.nextLine();
        }
        return email;
    }
    /**
     * method that "logs in" an existing user retrieving information from SQL database
     * calls retrieveFirstNameSQL() with an email input to find correct user row in SQL, then calls mainMenu()
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void logInUser() throws SQLException, ClassNotFoundException {
        MySQLAccess userSQL = new MySQLAccess();
       this.email = getValidEmail();
        userSQL.retrieveFirstNameSQL(this.email);
        while (userSQL.retrieveFirstNameSQL(this.email) == null) {
            System.out.println("Email not found, please try again..");
            this.email = getValidEmail();

        }
        System.out.println("---------------------------");
        System.out.println("Welcome Back, " + userSQL.retrieveFirstNameSQL(this.email) + "!");
        System.out.println("---------------------------");
        mainMenu(this.email);
    }

    /**
     * displays menu options, and funnels user to appropriate data retrieval from SQL, utilizing 1 of 4 methods, or exits app
     */
    public void mainMenu(String email) {
        MySQLAccess userSQL = new MySQLAccess();
        int response;
        try {
            System.out.println("1) View ACCOUNT BALANCES");
            System.out.println("2) View DEBT PROFILE");
            System.out.println("3) View GOALS TIMELINE");
            System.out.println("4) View PERSONAL INFO");
            System.out.println("5) Exit");
            response = scanner.nextInt();
            scanner.nextLine();
            while (response < 0 || response > 5) {
                System.out.println("Invalid entry, please enter 1-5:");
                response = scanner.nextInt();
            }

            switch (response) {
                case 1:
                    userSQL.viewUserAccountBalances(email);
                    break;
                case 2:
                    userSQL.viewUserDebtProfile(email);
                    break;
                case 3:
                    userSQL.viewUserGoalsTimeline(email);
                    break;
                case 4:
                    userSQL.viewPersonalInfo(email);
                    break;
                default:
                    System.out.println("Good Bye!");
            }
        } catch (InputMismatchException | SQLException | ClassNotFoundException e) {
            System.out.println("You must enter a valid number, please try again...");
            scanner.next();
            mainMenu(email);
        }

    }

    /**
     * method that returns a user to the main menu, when ready
     * @param email - user's email
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void returnToMainMenu(String email) throws SQLException, ClassNotFoundException {
        System.out.println("Enter \"back\" to return to main menu....");
        String response = scanner.nextLine();
        while (!response.equalsIgnoreCase("back")) {
            System.out.println("That's not an option, enter \"back\" to return to Main Menu...");
            response = scanner.nextLine();
        }
        LogInAndMenus menu = new LogInAndMenus();
        menu.mainMenu(email);
    }

}


