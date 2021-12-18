package my_budget_app.data;

import my_budget_app.model.WeeklyExpenses;

import java.sql.SQLException;

public class WeeklyExpensesToSQL extends DBParent {

    public void addWeeklyExpensesToTable(WeeklyExpenses weekly) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO weekly_expenses(groceries, childcare, fuel, misc) VALUES('" +
                weekly.getGroceries() + "', '" + weekly.getChildcare() + "', '" + weekly.getFuelForAutomobile() + "', '" + weekly.getMisc() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeWeeklyExpensesFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM weekly_expenses i WHERE i.income_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }
}
