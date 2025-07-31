import java.sql.*;
import java.util.List;

public class EnrollmentDBHandler {

    public static void saveAll(List<Enrollment> enrollments) {
        String sql = "INSERT IGNORE INTO enrollments (enr_id ,s_id, c_id, grade, attendance) VALUES (? , ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Enrollment e : enrollments) {
                stmt.setInt(1, e.getEnrol_id());
                stmt.setInt(2, e.getStudentId());
                stmt.setInt(3, e.getCourseId());
                stmt.setDouble(4, e.getGrade());
                stmt.setInt(5, e.getAttendedDays());
                stmt.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void viewEnrollmentsDB() {
        String query = "SELECT * FROM enrollments";
        try {
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Header
            System.out.printf("%-8s | %-10s | %-10s | %-8s | %-6s%n",
                    "Enr_ID", "Student_ID", "Course_ID", "Attend", "Grade");
            System.out.println("--------------------------------------------------------");

            // Rows
            while (rs.next()) {
                int enrId = rs.getInt("enr_id");
                int studentId = rs.getInt("s_id");
                int courseId = rs.getInt("c_id");
                int attendance = rs.getInt("attendance");
                double grade = rs.getDouble("grade");

                System.out.printf("%-8d | %-10d | %-10d | %-8d | %-6.2f %n",enrId, studentId, courseId, attendance, grade);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
