package my_budget_app.data;

import my_budget_app.model.Goals;

import java.sql.SQLException;

public class GoalsToSQL extends DBParent {

    public void addGoalsToTable(Goals goals) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO goals(savings, vacation, retirement, misc) VALUES('" + goals.getSavings() + "', '" + goals.getVacation() + "', '" + goals.getRetirement() + "', '" + goals.getMisc() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeGoalFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM goals g WHERE g.goals_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }
}
