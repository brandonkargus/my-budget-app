package my_budget_app.data;

import my_budget_app.model.User;

import java.sql.SQLException;

public class UserToSQL extends DBParent {

    public void addUserToTable(User user) throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO users(first_name, last_name, email, address, phone) VALUES('" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getEmail() + "', '" + user.getAddress() + "', '" + user.getPhone() + "')";
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }

    public void removeUserFromTable(int id) throws SQLException, ClassNotFoundException {
        String sqlStatement = "DELETE FROM users u WHERE u.user_id = " + id;
        connectToDatabase();
        int insert = statement.executeUpdate(sqlStatement);
        statement.close();
        connection.close();
    }
}
