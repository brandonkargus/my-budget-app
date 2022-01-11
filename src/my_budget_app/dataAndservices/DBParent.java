package my_budget_app.dataAndservices;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.*;

/**
 * class containing general use methods for SQL connection and disconnection
 */
public class DBParent {
    public Connection connection = null;
    public Statement statement = null;
    public ResultSet resultSet = null;

    /**
     * -method used to connect to local database, MODIFY AS NEEDED TO CONNECT SUCCESSFULLY (database name, password, etc.)
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void connectToDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost/my_budget_db?"
<<<<<<< HEAD:src/my_budget_app/data/DBParent.java
                + "user=root&password=******"
=======
                + "user=root&password=" + URLEncoder.encode(System.getenv("SECRET_KEY"), Charset.defaultCharset())
>>>>>>> version_3:src/my_budget_app/dataAndservices/DBParent.java
                + "&useSSL=false&allowPublicKeyRetrieval=true";
        connection = DriverManager.getConnection(connectionString);
        statement = connection.createStatement();
    }

    /**
     * general use method that closes all SQL related objects in one call
     */
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


