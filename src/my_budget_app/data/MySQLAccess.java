package my_budget_app.data;

import java.sql.SQLException;

import static my_budget_app.controllers.LogInAndMenus.returnToMainMenu;

/**
 * class containing methods that interact with the "user" table in SQL
 */
public class MySQLAccess extends DBParent {

    /**
     * retrieve first name of user from SQL database using existing email
     *
     * @param email
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public String retrieveFirstNameSQL(String email) throws SQLException, ClassNotFoundException {
        String sqlStatement = "SELECT * FROM users u WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);

        String firstName = null;

        while (resultSet.next()) {
            firstName = resultSet.getString("first_name");
        }
        close();
        return firstName;
    }

    /**
     * method that queries and prints a user's account balances from SQL using the email provided
     *
     * @param email - email entered by user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void viewUserAccountBalances(String email) throws SQLException, ClassNotFoundException {
        String sqlStatement = "SELECT * FROM accounts a JOIN users u ON a.account_id = u.account WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {
            int id = resultSet.getInt("account_id");
            int checking = resultSet.getInt("checking");
            int savings = resultSet.getInt("savings");
            System.out.println("ACCOUNT Number: " + id);
            System.out.println("Your ACCOUNT balances are as follows...");
            System.out.println("CHECKING: $" + checking);
            System.out.println("SAVINGS: $" + savings);
            System.out.println("-------------------------------");
        }
        close();
        returnToMainMenu(email);
    }

    /**
     * method that queries and prints a user's debt profile from SQL using the email provided
     *
     * @param email - email entered by user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void viewUserDebtProfile(String email) throws SQLException, ClassNotFoundException {
        int studentLoanMonthly = 450;
        int vehiclePayment = 325;
        String sqlStatement = "SELECT * FROM debts d JOIN users u ON d.debts_id = u.debts WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {
            int studentLoans = resultSet.getInt("student_loans");
            int homeLoans = resultSet.getInt("home_loan");
            int autoLoans = resultSet.getInt("auto_loan");
            int creditCard = resultSet.getInt("credit_card");
            int misc = resultSet.getInt("misc");
            System.out.println("Your DEBT profile is as follows...");
            System.out.println("STUDENT LOANS: " + studentLoans);
            System.out.println("HOME LOANS: " + homeLoans);
            System.out.println("AUTO LOANS: " + autoLoans);
            System.out.println("CREDIT CARD(s): " + creditCard);
            System.out.println("MISC: " + misc);
            System.out.println("-------------------------------------");
            System.out.println("QUICK FACTS..");
            System.out.println("- If you pay $" + studentLoanMonthly + " per month on your student loans, it will take you approximately " + (studentLoans / studentLoanMonthly)
                    + " months (~" + ((studentLoans / studentLoanMonthly) / 12) + " years) to pay off.");
            System.out.println();
            System.out.println("- If you make a vehicle payment of " + vehiclePayment + " per month, it will take you about " + (autoLoans / vehiclePayment)
                    + " months (~" + ((autoLoans / vehiclePayment) / 12) + " years) to pay off your vehicle.");
            System.out.println("--------------------------------------");
        }
        close();
        returnToMainMenu(email);
    }

    /**
     * method that queries and prints a user's goals from SQL using the email provided
     *
     * @param email - email entered by user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void viewUserGoalsTimeline(String email) throws SQLException, ClassNotFoundException {
        int monthlySavings = 400;
        int vacationSavings = 150;
        String sqlStatement = "SELECT * FROM goals g JOIN users u ON g.goals_id = u.goals WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {
            int savings = resultSet.getInt("savings");
            int vacation = resultSet.getInt("vacation");
            int retirement = resultSet.getInt("retirement");
            int misc = resultSet.getInt("misc");
            System.out.println("Your SAVINGS goals are as follows....");
            System.out.println("SAVINGS: " + savings);
            System.out.println("VACATION: " + vacation);
            System.out.println("RETIREMENT: " + retirement);
            System.out.println("MISC: " + misc);
            System.out.println("---------------------------------");
            System.out.println("SAVINGS TIMELINE...");
            System.out.println("Saving $" + monthlySavings + " per month, will allow you to reach your SAVINGS goal in about " + (savings / monthlySavings) + " months.");
            System.out.println("If you can manage to save $" + vacationSavings + " per week additional, you will hit your vacation goal in " + (vacation / (vacationSavings * 4))
                    + " months.");
            System.out.println("----------------------------------");
        }
        close();
        returnToMainMenu(email);

    }

    /**
     * method that queries and prints a user's personal information from SQL using the email provided
     *
     * @param email - email entered by user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void viewPersonalInfo(String email) throws SQLException, ClassNotFoundException {
        String sqlStatement = "SELECT * FROM users u WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {
            String first = resultSet.getString("first_name");
            String last = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            System.out.println("Your PERSONAL INFORMATION on file is as follows....");
            System.out.println("---------------------------------");
            System.out.println("FIRST NAME: " + first);
            System.out.println("LAST NAME: " + last);
            System.out.println("EMAIL: " + email);
            System.out.println("ADDRESS: " + address);
            System.out.println("PHONE: " + phone);
            System.out.println("---------------------------------");
        }
        close();
        returnToMainMenu(email);

    }
}
