package my_budget_app.brandon_3.controllers;

import my_budget_app.brandon_3.mappers.UserMapper;
import my_budget_app.brandon_3.pojos.User;
import my_budget_app.brandon_3.utils.UserInputUtils;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    UserMapper userMapper = new UserMapper();

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public void welcomeUser() {
        System.out.println("Welcome back to your Budget App! What would you like to do? (1/2)");
    }

    public User logInUser(){

        System.out.println("Please enter your email:");
        String email = readValidEmail();

        try {
            User user = userMapper.findUserByEmail(email);

            if(user != null) {
                user.setAccounts(userMapper.loadUserAccountsById(user));
                user.setGoals(userMapper.loadUserGoalsById(user.getUserId()));
                user.setDebts(userMapper.loadUserDebtsById(user.getUserId()));
                return user;
            } else {
                System.out.println("User with email " + email + " not found");
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String readValidEmail() {

        Scanner scanner = new Scanner(System.in);
        String email = "";

        while (true) {
            try {
                email = scanner.next();

                if (UserController.validate(email)) {
                    break;
                }
            } catch(Exception e){
                System.out.println("please enter a valid email");
                continue;
            }
        }

        return email;
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public User createNewUser() {

        // do all the things to create a new user

        // get all their account info etc

        return null;
    }

    public void loadUserMenu(User user) {

        System.out.println("You've logged in!");

        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1) View ACCOUNT BALANCES");
            System.out.println("2) View DEBT PROFILE");
            System.out.println("3) View GOALS TIMELINE");
            System.out.println("4) View PERSONAL INFO");
            System.out.println("5) Exit");

            int response = UserInputUtils.getValidIntInput(5);

            switch(response){
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
}
