package my_budget_app.data;

import my_budget_app.model.Income;

import java.sql.SQLException;

public class IncomeToSQL extends DBParent {

    public void addIncomeToTable(Income income) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO income(income_amount, income_source, income_frequency) VALUES('" + income.getAmount() + "', '" + income.getSource() + "', '" + income.getFrequency() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeIncomeFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM income i WHERE i.income_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }
}
