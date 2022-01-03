package my_budget_app.brandon_3.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputUtils {

    public static int getValidIntInput(int range) {
        Scanner scanner = new Scanner(System.in);

        int response = 0;
        boolean validEntry = true;

        while(validEntry) {
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

}
