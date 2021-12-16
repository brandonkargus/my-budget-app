package my_budget_app.controllers;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;


public class MyBudgetApp {
    Scanner scanner = new Scanner(System.in);
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static void runApp() {
        System.out.println("Welcome to your Budgeting App!");
        System.out.println();
        System.out.println("Please select from the following menu options:");
        System.out.println("1) View Account Balances");
        System.out.println("2) View Overview Stats");
        System.out.println("3) Customize Budget (add/update/delete income & expenses)");
        System.out.println("4) Run Customized Reports");
        System.out.println("5) Exit");

    }

    public void connectToDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost/my_budget_app_db?"
                + "user=root&password=****"
                + "&useSSL=false&allowPublicKeyRetrieval=true";
        connection = DriverManager.getConnection(connectionString);
        statement = connection.createStatement();


    }

    public void addUserToTable() throws SQLException, ClassNotFoundException {
        String sqlStatement = "INSERT INTO users(first_name, last_name, email, address, phone) VALUES('Doug', 'Rain', 'dr@gmail.com', '34343 Mountain Way, Denver, Colorado, USA', '507-343-8796')";
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


    public static void main(String[] args) throws Exception {
        MyBudgetApp user = new MyBudgetApp();

        user.addUserToTable();

    }


}
