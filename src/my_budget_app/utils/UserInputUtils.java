package my_budget_app.utils;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class which houses "user entry validation" methods
 */
public class UserInputUtils {

    /**
     * takes in a user's input and ensures it's an int, and that int falls within a prescribed range
     *
     * @param range -
     * @return
     */
    public static int getValidIntInput(int range) {
        Scanner scanner = new Scanner(System.in);

        int response = 0;
        boolean validEntry = true;

        while (validEntry) {
            try {
                response = scanner.nextInt();

                while (response < 1 || response > range) {
                    System.out.println("Invalid entry, please enter a number from the list:");
                    response = scanner.nextInt();
                }

                validEntry = false;

            } catch (InputMismatchException e) {
                System.out.println("Error, please enter a number:");
                scanner.next();
            }
        }

        return response;
    }

    /**
     * takes in a user's input and ensures it's valid for BigDecimal
     *
     * @return
     */
    public static BigDecimal getValidBigDecimalInput() {
        Scanner scanner = new Scanner(System.in);

        BigDecimal input = scanner.nextBigDecimal();

        while (input.compareTo(BigDecimal.valueOf(0)) < 0) {
            System.out.println("Number cannot be negative, please try again...");
            input = scanner.nextBigDecimal();
        }
        return input;
    }
}
