import java.util.ArrayList;
import java.util.List;

public class CourseParser {

    public static List<Course> parse(List<String[]> rawData) {
        List<Course> courses = new ArrayList<>();

        for (String[] row : rawData) {
            try {
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                int credit = Integer.parseInt(row[2]);
                String ins_name = row[3];

                Course course = new Course(id, name, credit,ins_name);
                courses.add(course);
            } catch (Exception e) {
                System.out.println("Error in courseParser the line : " + String.join(",", row));
            }
        }

        return courses;
    }
}
