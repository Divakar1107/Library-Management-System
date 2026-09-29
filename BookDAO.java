import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {

    // ADD BOOK
    public static void addBook(int bookId, String title, String author) {

        String sql =
                "INSERT INTO books (book_id, title, author, available) VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, bookId);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setBoolean(4, true);

            ps.executeUpdate();

            System.out.println("Book saved to database!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // DISPLAY BOOKS
    public static void displayBooks() {

        String sql = "SELECT * FROM books";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            java.sql.ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Available: " + rs.getBoolean("available"));

                System.out.println();
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // SEARCH BOOK
    public static void searchBook(int bookId) {

        String sql =
                "SELECT * FROM books WHERE book_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, bookId);

            java.sql.ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Available: " + rs.getBoolean("available"));

            } else {

                System.out.println("Book not found.");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}