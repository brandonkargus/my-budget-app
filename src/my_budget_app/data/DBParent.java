package my_budget_app.data;

import java.sql.*;

public class DBParent {
    public Connection connection = null;
    public Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public void connectToDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost/my_budget_app_db?"
                + "user=root&password=*****"
                + "&useSSL=false&allowPublicKeyRetrieval=true";
        connection = DriverManager.getConnection(connectionString);
        statement = connection.createStatement();
    }
}


