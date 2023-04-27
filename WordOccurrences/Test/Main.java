import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class provides an example of how to establish a JDBC connection to a MySQL database.
 * It requires the MySQL JDBC driver to be installed in the project's classpath.
 * The class prints a message indicating whether the connection was successful or not.
 */
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/word_occurrences";
        String username = "root";
        String password = "Anarchy56!";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database.");
            // Use the connection here.
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}