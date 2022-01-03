package my_budget_app.brandon_3.controllers;

import my_budget_app.brandon_3.data.JavaToSQL;
import my_budget_app.brandon_3.models.Accounts;
import my_budget_app.brandon_3.models.Debts;
import my_budget_app.brandon_3.models.Goals;
import my_budget_app.brandon_3.models.User;
import my_budget_app.brandon_3.utils.UserInputUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    JavaToSQL javaToSql = new JavaToSQL();

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public void welcomeUser() {
        System.out.println("Welcome back to your Budget App! What would you like to do? (enter 1 or 2)");
    }

    public User logInUser() {

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
            throwable.printStackTrace();
        }

        return null;
    }
    public void loadUserMenu(User user) {

        System.out.println("You're logged in, " + user.getFirst_name() + "!");
        System.out.println();

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1) View ACCOUNT BALANCE(s)");
            System.out.println("2) View DEBT PROFILE(s)");
            System.out.println("3) View GOAL ENTRIES");
            System.out.println("4) View PERSONAL INFO");
            System.out.println("5) Exit");

            int response = UserInputUtils.getValidIntInput(5);

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
                    System.out.println("Goodbye! :)");
                    return;
            }
        }

    }

    private String readValidEmail() {

        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        while (!UserController.validate(email)) {
            System.out.println("Please enter a valid email...");
            email = scanner.nextLine();

        }

        return email;
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

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
            System.out.println("Please enter your email:");
            email = scanner.nextLine();
            while (!UserController.validate(email)) {
                System.out.println("Invalid email format, please try again...");
                email = scanner.nextLine();
            }
            System.out.println("Please enter your address:");
            address = scanner.nextLine();
            System.out.println("Please enter your phone number:");
            phone = scanner.nextLine();
            System.out.println("--------------------------");

        } catch (Exception e) {
            System.out.println("Error adding user, please try again...");
        }
        user = new User(first, last, email, address, phone);
        javaToSql.createUserInSQL(user);  //sent user data to SQL

        JavaToSQL getUserFromDB = new JavaToSQL();
        user = getUserFromDB.findUserByEmail(email);  //pull user data BACK FROM SQL and reassigned to user

        System.out.println(user.toString()); //added to verify population of "user_id" field

        javaToSql.createAccountInSQL(createNewAccount(user));     //TODO why is this throwing "cannot add or update, foreign key constraint fails?

        javaToSql.createDebtsInSQL(createNewDebtProfile(user));

        javaToSql.createGoalsInSQL(createNewGoalsSet(user));

        return user;
    }

    public Accounts createNewAccount(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("We will now save some account information..");
        System.out.println();
        BigDecimal checking, savings;
        while (true) {
            checking = null;
            savings = null;
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


    }

    public Debts createNewDebtProfile(User user) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal studentLoans = null, homeLoan = null, autoLoans = null, creditCard = null, misc = null;

        try {
            System.out.println("We will now get some information about your debts...");
            System.out.println();
            System.out.println("Please enter your total student loans (0 for none):");
            studentLoans = scanner.nextBigDecimal();
            while (studentLoans.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                studentLoans = scanner.nextBigDecimal();
            }
            System.out.println("Please enter your total home loan (0 for none):");
            homeLoan = scanner.nextBigDecimal();
            while (homeLoan.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                homeLoan = scanner.nextBigDecimal();
            }
            System.out.println("Please enter your total automobile loans (0 for none):");
            autoLoans = scanner.nextBigDecimal();
            while (autoLoans.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                autoLoans = scanner.nextBigDecimal();
            }
            System.out.println("Please enter your total credit card balance (0 for none):");
            creditCard = scanner.nextBigDecimal();
            while (creditCard.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                creditCard = scanner.nextBigDecimal();
            }
            System.out.println("Please enter any other outstanding amount owed (0 for none):");
            misc = scanner.nextBigDecimal();
            while (misc.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                misc = scanner.nextBigDecimal();
            }


        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, numbers only.  Starting over.....");
            System.out.println("-------------------------------");
            scanner.next();
            createNewDebtProfile(user);
        }
        return new Debts(user.getUserId(), studentLoans, homeLoan, autoLoans, creditCard, misc);

    }

    public Goals createNewGoalsSet(User user) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal savings = null, vacation = null, retirement = null, misc = null;
        try {
            System.out.println("Now, it's time to create a new set of goals...");
            System.out.println();
            System.out.println("Please enter a savings goal:");
            savings = scanner.nextBigDecimal();
            while (savings.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                savings = scanner.nextBigDecimal();
            }
            System.out.println("Please enter a vacation goal:");
            vacation = scanner.nextBigDecimal();
            while (vacation.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                vacation = scanner.nextBigDecimal();
            }
            System.out.println("Please enter a retirement goa:l");
            retirement = scanner.nextBigDecimal();
            while (retirement.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                retirement = scanner.nextBigDecimal();
            }
            System.out.println("Please enter any other general purpose goal:");
            misc = scanner.nextBigDecimal();
            while (misc.compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("Number cannot be negative, please try again...");
                misc = scanner.nextBigDecimal();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, numbers only.  Starting over....");
            System.out.println("----------------------------------");
            scanner.next();
            createNewGoalsSet(user);
        }
        return new Goals(user.getUserId(), savings, vacation, retirement, misc);

    }

}
