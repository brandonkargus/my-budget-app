package my_budget_app.services;

import my_budget_app.data.DBParent;

import java.sql.SQLException;

public class ViewStudentLoanTimeline extends DBParent {

    public void getStudentLoanTimeline() throws SQLException, ClassNotFoundException {
        int monthlyPayment = 0;
        int totalLoans = 0;
        connectToDatabase();

        resultSet = statement.executeQuery("SELECT * FROM my_budget_app_db.monthly_expenses " +
                "WHERE monthly_expenses.monthly_expenses_id = 17");
        while (resultSet.next()) {
            int id = resultSet.getInt("monthly_expenses_id");
            int housing = resultSet.getInt("housing");
            int auto = resultSet.getInt("auto");
            int phone = resultSet.getInt("phone");
            int utilities = resultSet.getInt("utilities");
            monthlyPayment = resultSet.getInt("student_loans");
            int creditCard = resultSet.getInt("credit_card");
            int misc = resultSet.getInt("misc");
            int entertainment = resultSet.getInt("entertainment");

        }
        resultSet = statement.executeQuery("SELECT * FROM my_budget_app_db.debts " + "WHERE debts.debts_id = 10");
        while (resultSet.next()) {
            int id = resultSet.getInt("debts_id");
            totalLoans = resultSet.getInt("student_loans");
            int home = resultSet.getInt("home_loan");
            int auto = resultSet.getInt("auto_loan");
            int creditCard = resultSet.getInt("credit_card");
            int misc = resultSet.getInt("misc");
        }

        int months = totalLoans / monthlyPayment;
        System.out.println("Based on your current repayment plan, it will take you " + "~" + months + " months, (or ~" + (months / 12) + " years) to pay off your Student loan(s)");

        resultSet.close();
        statement.close();
        connection.close();

    }

}
