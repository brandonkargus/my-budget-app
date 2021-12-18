package my_budget_app.services;

import my_budget_app.data.DBParent;

import java.sql.SQLException;
import java.util.Scanner;


public class RunAccountBalances extends DBParent {
    Scanner scanner = new Scanner(System.in);

    public void getAccountBalances() throws SQLException, ClassNotFoundException {
        System.out.println("Please enter your id number: ");
        int number = scanner.nextInt();
        while(number < 1){
            System.out.println("Invalid id, please try again...");
            number = scanner.nextInt();
        }
        connectToDatabase();
        resultSet = statement.executeQuery("SELECT * FROM my_budget_app_db.account_balances WHERE account_balances.account_balances_id = " + number);
        while(resultSet.next()) {
            int id = resultSet.getInt("account_balances_id");
            int checking = resultSet.getInt("checking_account");
            int savings = resultSet.getInt("savings_account");
            System.out.println("Information for account number " + id + "....");
            System.out.println("CHECKING ACCOUNT BALANCE: $" + checking);
            System.out.println("SAVINGS ACCOUNT BALANCE: $" + savings);

        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
