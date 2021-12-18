package my_budget_app.data;

import my_budget_app.model.Debts;

import java.sql.SQLException;

public class DebtToSQL extends DBParent{

    public void addDebtToTable(Debts debt) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO debts(student_loans, home_loan, auto_loan, credit_card, misc) VALUES('" +
                debt.getStudentLoans() + "', '" + debt.getHomeLoans() + "', '" + debt.getAutoLoan() + "', '" + debt.getCreditCard() + "', '" + debt.getMisc() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeDebtFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM debts i WHERE i.income_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

}
