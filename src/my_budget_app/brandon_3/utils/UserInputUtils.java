package my_budget_app.brandon_3.utils;

import java.util.Scanner;

public class UserInputUtils {

    public static int getValidIntInput(int range){
        Scanner scanner = new Scanner(System.in);

        int response = scanner.nextInt();

        while (response < 1 || response > range) {
            System.out.println("Invalid entry, please type 1 or 2:");
            response = scanner.nextInt();
        }
        return response;
    }

}
