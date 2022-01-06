package my_budget_app.controllers;

import my_budget_app.dataAndservices.JavaToSQL;
import my_budget_app.models.Accounts;
import my_budget_app.models.Debts;
import my_budget_app.models.Goals;
import my_budget_app.models.User;
import my_budget_app.utils.UserInputUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static my_budget_app.controllers.AppController.runApp;

/**
 * class that controls interaction with user, including new user creation in SQL
 */
public class UserController {

    JavaToSQL javaToSql = new JavaToSQL();

    /**
     * RegEx pattern to validate email format
     */
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    /**
     * pretty self-explanatory
     */
    public void welcomeUser() {
        System.out.println("Welcome to \"My Budget App\"! What would you like to do? (Enter 1 or 2)");
    }

    /**
     * checks if user exists in SQL.  A new user is created with the information found.  Null returned if not found
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User logInUser() throws SQLException, ClassNotFoundException {

        System.out.println("Please enter your email:");
        String email = readValidEmail();

        try {
            User user = javaToSql.findUserByEmail(email);

            if (user != null) {
                user.setAccounts(javaToSql.loadUserAccountsById(user));
                user.setGoals(javaToSql.loadUserGoalsById(user.getUserId()));
                user.setDebts(javaToSql.loadUserDebtsById(user.getUserId()));
                return user;
            } else {
                System.out.println("User with email " + email + " not found");
                return null;
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            System.out.println("Error has occurred, try again...");
            System.out.println();
            logInUser();
        }

        return null;
    }

    /**
     * loads user menu once a valid user has been created/located, and data retrieved
     *
     * @param user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void loadUserMenu(User user) throws SQLException, ClassNotFoundException {

        System.out.println("You're logged in, " + user.getFirst_name() + "!");
        System.out.println();

        boolean quit = false;

        while (!quit) {
            System.out.println("What would you like to do?");
            System.out.println("1) View ACCOUNT BALANCE(s)");
            System.out.println("2) View DEBT PROFILE(s)");
            System.out.println("3) View GOAL ENTRIES");
            System.out.println("4) View PERSONAL INFO");
            System.out.println("5) View TOTAL DEBT");
            System.out.println("6) View TOTAL GOALS");
            System.out.println("7) Log out");

            int response = UserInputUtils.getValidIntInput(7);

            switch (response) {
                case 1:
                    user.printAccounts();
                    break;
                case 2:
                    user.printDebts();
                    break;
                case 3:
                    user.printGoals();
                    break;
                case 4:
                    user.printInfo();
                    break;
                case 5:
                    user.printTotalDebts();
                    break;
                case 6:
                    user.printTotalGoals();
                    break;
                case 7:
                    System.out.println("You've logged out, returning to main menu....");
                    System.out.println();
                    quit = true;
                    runApp();

            }
        }
    }

    /**
     * ensures user entered email adheres to proper format before returning as a String
     *
     * @return
     */
    private String readValidEmail() {

        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        while (!UserController.validate(email)) {
            System.out.println("Please enter a valid email...");
            email = scanner.nextLine();
        }

        return email;
    }

    /**
     * compares String (emailStr) against the RegEx "proper email" format
     *
     * @param emailStr
     * @return
     */
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);

        return matcher.find();
    }

    /**
     * creates a new user object and adds a new accounts, debts, goals, object.  The information is passed to SQL, and returned with Primary Key (user_id) for user column attached.  User object then returned
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User createNewUser() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String email = null;
        User user;
        String first = null;
        String last = null;
        String address = null;
        String phone = null;
        try {
            System.out.println("Ok!  Let's begin with some personal information...");
            System.out.println();
            System.out.println("Please enter your first name:");
            first = scanner.nextLine();
            System.out.println("Please enter your last name:");
            last = scanner.nextLine();

            do {
                System.out.println("Please enter your email:");
                email = scanner.nextLine();
                while (!UserController.validate(email)) {
                    System.out.println("Invalid email format, please try again...");
                    email = scanner.nextLine();
                }

                user = javaToSql.checkUserExistsInSQL(email);
                if (user != null) {
                    System.out.println("User with that email already exists.....");
                }

            } while (user != null);

            System.out.println("Please enter your address:");
            address = scanner.nextLine();
            System.out.println("Please enter your phone number:");
            phone = scanner.nextLine();
            System.out.println("--------------------------");

        } catch (Exception e) {

            System.out.println("Error adding user, please try again...");
        }

        user = new User(first, last, email, address, phone);
        javaToSql.createUserInSQL(user);

        JavaToSQL getUserFromDB = new JavaToSQL();
        user = getUserFromDB.findUserByEmail(email);

        javaToSql.createAccountInSQL(createNewAccount(user));
        javaToSql.createDebtsInSQL(createNewDebtProfile(user));
        javaToSql.createGoalsInSQL(createNewGoalsSet(user));

        user.setAccounts(javaToSql.loadUserAccountsById(user));
        user.setDebts(javaToSql.loadUserDebtsById(user.getUserId()));
        user.setGoals(javaToSql.loadUserGoalsById(user.getUserId()));

        return user;
    }

    /**
     * used to take in user input for Accounts creation information, returns new Accounts object, passing user_id (Foreign Key in this table) allows creation in SQL
     *
     * @param user
     * @return
     */
    public Accounts createNewAccount(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("We will now save some account information..");
        System.out.println();

        BigDecimal checking = null, savings = null;

        try {
            System.out.println("Please enter the Checking account balance from the account you wish to add:");
            checking = scanner.nextBigDecimal();
            System.out.println("Next, please enter the Savings account balance from this account:");
            savings = scanner.nextBigDecimal();

        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, please enter numbers only...");
            System.out.println();
            scanner.next();
            createNewAccount(user);
        }

        return new Accounts(user.getUserId(), checking, savings);

    }

    /**
     * used to take in user input for Debts creation information, returns new Debts object, passing user_id (Foreign Key in this table) allows creation in SQL
     *
     * @param user
     * @return
     */
    public Debts createNewDebtProfile(User user) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal studentLoans = null, homeLoan = null, autoLoans = null, creditCard = null, misc = null;

        try {
            System.out.println("We will now get some information about your debts...");
            System.out.println();

            System.out.println("Please enter your total student loans (0 for none):");
            studentLoans = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter your total home loan (0 for none):");
            homeLoan = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter your total automobile loans (0 for none):");
            autoLoans = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter your total credit card balance (0 for none):");
            creditCard = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter any other outstanding amount owed (0 for none):");
            misc = UserInputUtils.getValidBigDecimalInput();

        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, numbers only.  Starting over.....");
            System.out.println("-------------------------------");
            scanner.next();
            createNewDebtProfile(user);
        }

        return new Debts(user.getUserId(), studentLoans, homeLoan, autoLoans, creditCard, misc);

    }

    /**
     * used to take in user input for Goals creation information, returns new Goals object, passing user_id (Foreign Key in this table) allows creation in SQL
     *
     * @param user
     * @return
     */
    public Goals createNewGoalsSet(User user) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal savings = null, vacation = null, retirement = null, misc = null;
        try {
            System.out.println("Now, it's time to create a new set of goals...");
            System.out.println();

            System.out.println("Please enter a savings goal:");
            savings = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter a vacation goal:");
            vacation = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter a retirement goal:");
            retirement = UserInputUtils.getValidBigDecimalInput();

            System.out.println("Please enter any other general purpose goal:");
            misc = UserInputUtils.getValidBigDecimalInput();

        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, numbers only.  Starting over....");
            System.out.println("----------------------------------");
            scanner.next();
            createNewGoalsSet(user);
        }

        return new Goals(user.getUserId(), savings, vacation, retirement, misc);

    }
}
