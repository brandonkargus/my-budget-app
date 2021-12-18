package my_budget_app.data;

import my_budget_app.model.MonthlyExpenses;

import java.sql.SQLException;

public class MonthlyExpensesToSQL extends DBParent {
    public void addMonthlyExpensesToTable(MonthlyExpenses monthly) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO monthly_expenses(housing, auto, phone, utilities, student_loans, credit_card, misc, entertainment) VALUES('" +
                monthly.getHousing() + "', '" + monthly.getAuto() + "', '" + monthly.getPhone() + "', '" + monthly.getUtilities() + "', '" + monthly.getStudentLoans()
        + "', '" + monthly.getCreditCard() + "', '" + monthly.getMisc() + "', '" + monthly.getEntertainment() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeMonthlyExpensesFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM monthly_expenses i WHERE i.income_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

}
