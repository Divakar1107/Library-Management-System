import java.sql.Connection;
import java.sql.PreparedStatement;

public class IssueDAO {

    // ISSUE BOOK
    public static void issueBook(int issueId, int bookId, int studentId) {

        String updateBook =
                "UPDATE books SET available = false WHERE book_id = ?";

        String insertIssue =
                "INSERT INTO issues (issue_id, book_id, student_id, active) VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 =
                    con.prepareStatement(updateBook);

            ps1.setInt(1, bookId);

            ps1.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(insertIssue);

            ps2.setInt(1, issueId);
            ps2.setInt(2, bookId);
            ps2.setInt(3, studentId);
            ps2.setBoolean(4, true);

            ps2.executeUpdate();

            System.out.println("Book issued successfully!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // RETURN BOOK
    public static void returnBook(int bookId) {

        String updateBook =
                "UPDATE books SET available = true WHERE book_id = ?";

        String updateIssue =
                "UPDATE issues SET active = false WHERE book_id = ? AND active = true";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 =
                    con.prepareStatement(updateBook);

            ps1.setInt(1, bookId);

            ps1.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(updateIssue);

            ps2.setInt(1, bookId);

            ps2.executeUpdate();

            System.out.println("Book returned successfully!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // DISPLAY ISSUED BOOKS
    public static void displayIssuedBooks() {

        String sql =
                "SELECT i.issue_id, " +
                "b.book_id, b.title, b.author, " +
                "s.student_id, s.name, s.department, " +
                "i.active " +
                "FROM issues i " +
                "JOIN books b ON i.book_id = b.book_id " +
                "JOIN students s ON i.student_id = s.student_id " +
                "WHERE i.active = true";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            java.sql.ResultSet rs =
                    ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("\nIssue ID: " +
                        rs.getInt("issue_id"));

                System.out.println("Book:");
                System.out.println("Book ID: " +
                        rs.getInt("book_id"));
                System.out.println("Title: " +
                        rs.getString("title"));
                System.out.println("Author: " +
                        rs.getString("author"));

                System.out.println("\nStudent:");
                System.out.println("Student ID: " +
                        rs.getInt("student_id"));
                System.out.println("Name: " +
                        rs.getString("name"));
                System.out.println("Department: " +
                        rs.getString("department"));

                System.out.println("Issue Active: " +
                        rs.getBoolean("active"));
            }

            if (!found) {

                System.out.println(
                        "No books are currently issued."
                );
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}