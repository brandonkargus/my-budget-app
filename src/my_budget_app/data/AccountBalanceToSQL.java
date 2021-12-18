package my_budget_app.data;

import my_budget_app.model.AccountBalances;

import java.sql.SQLException;

public class AccountBalanceToSQL extends DBParent {

    public void addAccountBalanceToTable(AccountBalances ab) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO account_balances(checking_account, savings_account) VALUES('" + ab.getChecking() + "', '" + ab.getSavings() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeAccountBalanceFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM users u WHERE u.user_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

}
