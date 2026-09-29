import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    // ADD STUDENT
    public static void addStudent(int studentId, String name, String department) {

        String sql = "INSERT INTO students (student_id, name, department) VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setString(2, name);
            ps.setString(3, department);

            ps.executeUpdate();

            System.out.println("Student saved to database!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // DISPLAY STUDENTS
    public static void displayStudents() {

        String sql = "SELECT * FROM students";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));

                System.out.println();
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}