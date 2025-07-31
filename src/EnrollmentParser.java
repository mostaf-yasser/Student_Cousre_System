import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentParser {
    public static List<Enrollment> parse(List<String[]> rawData) {
        List<Enrollment> list = new ArrayList<>();

        for (String[] row : rawData) {
            try {
                int enrol_id = Integer.parseInt(row[0]);
                int studentId = Integer.parseInt(row[1]);
                int courseId = Integer.parseInt(row[2]);
                int attendedDays = Integer.parseInt(row[3]);
                double grade = Double.parseDouble(row[4]);

                list.add(new Enrollment(enrol_id , studentId, courseId, attendedDays, grade));
            } catch (Exception e) {
                System.out.println("Error in enrollmentParser the line :  " + String.join(",", row));
                System.out.println(e.getMessage());
            }
        }

        return list;
    }
}
