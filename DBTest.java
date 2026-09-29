
public class DBTest {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("MySQL JDBC driver found!");

        } catch (Exception e) {

            System.out.println("Driver not found.");
            e.printStackTrace();
        }
    }
}
