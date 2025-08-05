<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AppCreate {
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sample"; // Change 'your_database' to your DB name
        String user = "root"; // Change to your MySQL username
        String password = "root"; // Change to your MySQL password

        // SQL statement to create a table
        String sql = "CREATE TABLE IF NOT EXISTS data (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(100) NOT NULL," +
                     "value VARCHAR(100)" +
                     ")";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            stmt.executeUpdate(sql);
            System.out.println("Table 'data' created successfully.");

            // Get user input
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter value: ");
            String value = scanner.nextLine();

            // Insert user input into table
            String insertSql = "INSERT INTO data (name, value) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, value);
                pstmt.executeUpdate();
                System.out.println("Inserted a row into 'data' table.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======

>>>>>>> 75a788365e59c85f42c5a66c63f38c0166439b30
