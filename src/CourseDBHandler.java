import java.sql.*;
import java.util.List;

public class CourseDBHandler {

    public static void saveAll(List<Course> courses) {
        String sql = "INSERT IGNORE INTO course (course_id, course_name, credits,ins_name) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Course c : courses) {
                stmt.setInt(1, c.getId());
                stmt.setString(2, c.getName());
                stmt.setInt(3, c.getCredit());
                stmt.setString(4, c.getIns_name());
                stmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewCoursesDB() {
        String query = "SELECT * FROM course";
        try {
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("ID | Course Name         | Credit | Instructor");
            System.out.println("--------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("course_id");
                String name = rs.getString("course_name");
                int credit = rs.getInt("credits");
                String insName = rs.getString("ins_name");

                System.out.printf("%-3d| %-20s| %-7d| %s\n", id, name, credit, insName);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewCourseEnrollmentsDetails() {
        String query = "SELECT * FROM course_enrollments_details";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.printf("%-10s | %-20s | %-20s | %-10s | %-5s%n",
                    "Course ID", "Course Name", "Student Name", "Attendance", "Grade");
            System.out.println("-------------------------------------------------------------------------------------");

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String courseName = rs.getString("course_name");
                String studentName = rs.getString("student_name");
                int attendance = rs.getInt("attendance");
                int grade = rs.getInt("grade");

                System.out.printf("%-10d | %-20s | %-20s | %-10d | %-5d%n",
                        courseId, courseName, studentName, attendance, grade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
