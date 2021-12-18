package my_budget_app.services;

import my_budget_app.data.DBParent;

import java.sql.SQLException;

public class ViewSavingsGoals extends DBParent {

    public void getSavingsTimeLine() throws SQLException, ClassNotFoundException {
        connectToDatabase();
        resultSet = statement.executeQuery("SELECT * FROM my_budget_app_db.goals " + "WHERE goals.goals_id = 10");
        while (resultSet.next()) {
            int id = resultSet.getInt("goals_id");
            int savings = resultSet.getInt("savings");
            int vacation = resultSet.getInt("vacation");
            int retirement = resultSet.getInt("retirement");
            int misc = resultSet.getInt("misc");

            System.out.println("If you save $50 per week, it will take you about " + (savings / (50 * 4)) + " months to reach your SAVINGS goal.");
            System.out.println("$100 per week will get you there in about " + (savings / (100 * 4)) + " months.");
            System.out.println("If you can manage $150, you will be there in about " + (savings / (150 * 4)) + " months!!!");

        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}

