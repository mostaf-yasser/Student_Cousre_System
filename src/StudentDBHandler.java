import java.sql.*;
import java.util.List;

public class StudentDBHandler {

    public static void saveAll(List<Student> students) {
        String sql = "INSERT IGNORE INTO  student (std_id, f_name, l_name, birth, phone, email, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Student s : students) {
                stmt.setInt(1, s.getId());
                stmt.setString(2, s.getFirstName());
                stmt.setString(3, s.getLastName());
                stmt.setDate(4, Date.valueOf(s.getBirthDate()));
                stmt.setString(5, s.getPhone());
                stmt.setString(6, s.getEmail());
                stmt.setString(7, String.valueOf(s.getGender()));
                stmt.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Exception in saveAll func");
        }
    }

    public static void viewStudentsDB(){
        String query = "SELECT * FROM student";
        try{
            Connection conn = DatabaseUtil.getConnection();
            Statement Stm = conn.createStatement();
            ResultSet rs = Stm.executeQuery(query);
            System.out.printf("%-6s | %-20s | %-6s | %-12s | %-15s | %-30s%n","ID", "Name", "Gender", "Birth", "Phone", "Email");
            System.out.println("---------------------------------------------------------------");
            while(rs.next()){
                int id = rs.getInt("std_id");
                String f_name = rs.getString("f_name");
                String l_name = rs.getString("l_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                String birth = rs.getString("birth");
                System.out.printf("%-6d | %-20s | %-6s | %-12s | %-15s | %-30s%n",id, f_name + " " + l_name, gender, birth, phone, email);            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void viewStudentCourseCounts() {
        String query = "SELECT * FROM student_course_count";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.printf("%-10s | %-20s | %-12s%n", "Student ID", "Name", "Course Count");
            System.out.println("------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("std_id");
                String name = rs.getString("full_name");
                int count = rs.getInt("course_count");

                System.out.printf("%-10d | %-20s | %-12d%n", id, name, count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
