import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentParser{

    public static List<Student> parse(List<String[]> rawData) {
        List<Student> students = new ArrayList<>();

        for (String[] row : rawData) {
            try {
                int id = Integer.parseInt(row[0]);
                String firstName = row[1];
                String lastName = row[2];
                LocalDate birthDate = LocalDate.parse(row[3]);
                String phone = row[4];
                String email = row[5];
                char gender = row[6].charAt(0);

                Student student = new Student(id, firstName, lastName, birthDate, phone, email, gender);
                students.add(student);
            } catch (Exception e) {
                System.out.println("Exception in studentParser the line : " + String.join(",", row));
                System.out.println("Reason: " + e.getMessage());
            }
        }

        return students;
    }

}
