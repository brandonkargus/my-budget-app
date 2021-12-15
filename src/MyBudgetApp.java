import java.util.Scanner;

public class MyBudgetApp {
    Scanner scanner = new Scanner(System.in);

    public static void runApp() {
        System.out.println("Welcome to your Budgeting App!");
        System.out.println();
        System.out.println("Please select from the following menu options:");
        System.out.println("1) View Account Balances");
        System.out.println("2) View Overview Stats");
        System.out.println("3) Customize Budget (add/update/delete income & expenses)");
        System.out.println("4) Run Customized Reports");
        System.out.println("5) Exit");

    }

    public static void main(String[] args) {
        runApp();
    }


}
