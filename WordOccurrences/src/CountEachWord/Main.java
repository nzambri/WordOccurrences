package CountEachWord;
/**

 WordOccurrences class provides functionality to count the occurrences of each word in a given string.
 @author Nick Zambri
 @version 1.0
 @since 2023-04-17
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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