package my_budget_app.data;

import my_budget_app.brandon_3.models.*;
import my_budget_app.models.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class JavaToSQL extends DBParent3 {

    public User findUserByEmail(String email) throws SQLException, ClassNotFoundException {
        String sqlStatement = "SELECT * FROM users u WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);
        User u = null;

        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String first = resultSet.getString("first_name");
            String last = resultSet.getString("last_name");
            String email1 = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");

            u = new User(id, first, last, email1, address, phone);

        }
        close();
        return u;
    }

    public ArrayList<Accounts> loadUserAccountsById(User user) {

        String sqlStatement = "SELECT * FROM accounts where user_id = " + user.getUserId();

        ArrayList<Accounts> accounts = new ArrayList<>();

        try {
            connectToDatabase();
            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                int id = resultSet.getInt("account_id");
                BigDecimal checking = resultSet.getBigDecimal("checking");
                BigDecimal savings = resultSet.getBigDecimal("savings");
                Accounts account = new Accounts(id, checking, savings);
                accounts.add(account);
            }
            close();
        } catch(Exception e){
            System.out.println("critical error");
            e.printStackTrace();
            return null;
        }

        return accounts;
    }

    public ArrayList<Goals> loadUserGoalsById(int userId) {
        String sqlStatement = "SELECT * FROM goals where user_id = " + userId;

        ArrayList<Goals> goals = new ArrayList<>();

        try {
            connectToDatabase();
            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                int goals_id = resultSet.getInt("goals_id");
                int user_id = resultSet.getInt("user_id");
                BigDecimal savings = resultSet.getBigDecimal("savings");
                BigDecimal vacation = resultSet.getBigDecimal("vacation");
                BigDecimal retirement = resultSet.getBigDecimal("retirement");
                BigDecimal misc = resultSet.getBigDecimal("misc");
                Goals goalsProfile = new Goals(goals_id, user_id, savings, vacation, retirement, misc);
                goals.add(goalsProfile);
            }
            close();
        } catch(Exception e){
            System.out.println("critical error");
            return null;
        }

        return goals;
    }

    public ArrayList<Debts> loadUserDebtsById(int userId) {
        String sqlStatement = "SELECT * FROM debts where user_id = " + userId;

        ArrayList<Debts> debts = new ArrayList<>();

        try {
            connectToDatabase();
            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                int debt_id = resultSet.getInt("debts_id");
                int user_id = resultSet.getInt("user_id");
                BigDecimal student_loans = resultSet.getBigDecimal("student_loans");
                BigDecimal home_loan = resultSet.getBigDecimal("home_loan");
                BigDecimal auto_loan = resultSet.getBigDecimal("auto_loan");
                BigDecimal credit_card = resultSet.getBigDecimal("credit_card");
                BigDecimal misc = resultSet.getBigDecimal("misc");
                Debts debt = new Debts(debt_id, user_id, student_loans, home_loan, auto_loan, credit_card,  misc);
                debts.add(debt);
            }
            close();
        } catch(Exception e){
            System.out.println("critical error");
            return null;
        }

        return debts;
    }
    public void createUserInSQL(User user) throws SQLException {
        String sqlStatement = "INSERT INTO users(first_name, last_name, email, address, phone) VALUES('" + user.getFirst_name() + "', '" + user.getLast_name() + "', '" + user.getEmail() + "', '" + user.getAddress() + "', '" + user.getPhone() + "');";

        try {
            connectToDatabase();
            int x = statement.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.out.println("Error with user creation...");
        }
        close();
    }
    public void createAccountInSQL(Accounts account) {
        String sqlStatement = "INSERT INTO accounts(user_id, checking, savings) VALUES('" + account.getUser_id() + "', '" + account.getChecking()  + "', '" + account.getSavings() + "');";

        try {
            connectToDatabase();
            int x = statement.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.out.println("Error with account creation...");
            e.printStackTrace();
        }
        close();
    }
    public void createDebtsInSQL(Debts debts) {
        String sqlStatement = "INSERT INTO debts(user_id, student_loans, home_loans, auto_loan, credit_card, misc) VALUES('" + debts.getUser_id() + "', '" + debts.getStudent_loans() + "', '" + debts.getHome_loan() +
                "', '" + debts.getAuto_loan() + "', '" + debts.getCredit_card() + "', '" + debts.getMisc() + "');";

        try {
            connectToDatabase();
            int x = statement.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.out.println("Error with debts creation...");
        }
        close();
    }
    public void createGoalsInSQL(Goals goals) {
        String sqlStatement = "INSERT INTO goals(user_id, savings, vacation, retirement, misc) VALUES('" + goals.getUser_id() + "', '" + goals.getSavings() + "', '" + goals.getVacation() + "', '" + goals.getRetirement() +
                "', '" + goals.getMisc() + "');";

        try {
            connectToDatabase();
            int x = statement.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.out.println("Error with goals creation...");
        }
        close();
    }

}
