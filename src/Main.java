import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        connectDB();
        StudentDBHandler.viewStudentCourseCounts();
        CourseDBHandler.viewCourseEnrollmentsDetails();
//        EnrollmentsToDB();
//        EnrollmentDBHandler.viewEnrollmentsDB();
//        CoursesToDB();
//        CourseDBHandler.viewCoursesDB();
//        StudentsToDB();
//        StudentDBHandler.viewStudentsDB();
    }
    public static Connection connectDB() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public static void StudentsToDB(){
        List<String[]> studentsInFile = CSVReader.read("students.csv");
        if (!studentsInFile.isEmpty()) {
            studentsInFile.remove(0);
        }
        List<Student> listStudents = StudentParser.parse(studentsInFile);
        StudentDBHandler.saveAll(listStudents);
    }
    public static void CoursesToDB(){
        List<String[]> coursesInFile = CSVReader.read("courses.csv");
        if (!coursesInFile.isEmpty()) {
            coursesInFile.remove(0);
        }
        List<Course> listCourses = CourseParser.parse(coursesInFile);
        CourseDBHandler.saveAll(listCourses);
    }


    public static void EnrollmentsToDB(){
        List<String[]> enrollmentsInFile = CSVReader.read("enrollments.csv");
        if (!enrollmentsInFile.isEmpty()) {
            enrollmentsInFile.remove(0);
        }
        List<Enrollment> listEnrollments = EnrollmentParser.parse(enrollmentsInFile);
        EnrollmentDBHandler.saveAll(listEnrollments);
    }


    }
