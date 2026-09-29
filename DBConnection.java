import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/library_db";
            String username = "root";
            String password = "root";

            Connection con =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            return con;

        } catch (Exception e) {

            System.out.println("Database connection failed.");
            e.printStackTrace();

            return null;
        }
    }
}