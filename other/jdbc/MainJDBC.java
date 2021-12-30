package jdbc;

import java.sql.*;

public class MainJDBC {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "secret";
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "bill");
            statement.setString(2, "secretpass");
            statement.setString(3, "Bill Gates");
            statement.setString(4, "bill.gates@microsoft.com");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            String sql = "SELECT * FROM Users";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                String name = result.getString(2);
                String pass = result.getString(3);
                String fullname = result.getString("fullname");
                String email = result.getString("email");

                String output = "User #%d: %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, name, pass, fullname, email));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            String sql = "DELETE FROM Users WHERE username=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "bill");

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
