package my_budget_app.brandon_3.mappers;

import my_budget_app.brandon_3.pojos.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper extends DBParent3 {

    public User findUserByEmail(String email) throws SQLException, ClassNotFoundException {
        String sqlStatement = "SELECT * FROM users u WHERE u.email = '" + email + "';";
        connectToDatabase();
        resultSet = statement.executeQuery(sqlStatement);
        User u = null;

        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String first = resultSet.getString("first_name");
            String last = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");

            u = new User(id, first, last, email, address, phone);

        }
        close();
        return u;
    }

    public ArrayList<Account> loadUserAccountsById(User user) {

        String sqlStatement = "SELECT * FROM accounts where user_id = " + user.getUserId();

        ArrayList<Account> accounts = new ArrayList<>();

        try {
            connectToDatabase();
            resultSet = statement.executeQuery(sqlStatement);
            int count = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("account_id");
                int checking = resultSet.getInt("checking");
                int savings = resultSet.getInt("savings");
                Account account = new Account(id, checking, savings);
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

    public ArrayList<Goal> loadUserGoalsById(int userId) {
        String sqlStatement = "SELECT * FROM goals where user_id = " + userId;

        ArrayList<Goal> goals = new ArrayList<>();

        try {
            connectToDatabase();
            resultSet = statement.executeQuery(sqlStatement);
            int count = 0;
            while (resultSet.next()) {
                int goals_id = resultSet.getInt("goals_id");
                int savings = resultSet.getInt("savings");;
                int vacation = resultSet.getInt("vacation");;
                int retirement = resultSet.getInt("retirement");;
                int misc = resultSet.getInt("misc");;
                Goal account = new Goal(goals_id, savings, vacation, retirement, misc);
                goals.add(account);
            }
            close();
        } catch(Exception e){
            System.out.println("critical error");
            return null;
        }

        return goals;
    }

    public ArrayList<Debt> loadUserDebtsById(int userId) {
        String sqlStatement = "SELECT * FROM debts where user_id = " + userId;

        ArrayList<Debt> debts = new ArrayList<>();

        try {
            connectToDatabase();
            resultSet = statement.executeQuery(sqlStatement);
            int count = 0;
            while (resultSet.next()) {
                int debt_id = resultSet.getInt("debt_id");
                int student_loans = resultSet.getInt("student_loans");
                int home_loan = resultSet.getInt("home_loan");
                int auto_loan = resultSet.getInt("auto_loan");
                int credit_card = resultSet.getInt("credit_card");
                int misc = resultSet.getInt("misc");
                Debt debt = new Debt(debt_id, student_loans, home_loan, auto_loan, credit_card,  misc);
                debts.add(debt);
            }
            close();
        } catch(Exception e){
            System.out.println("critical error");
            return null;
        }

        return debts;
    }
}
