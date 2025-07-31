import java.time.LocalDate;

public class Enrollment {
    private int enrol_id;
    private int studentId;
    private int courseId;
    private int attendedDays;
    private double grade;

    public Enrollment(int enrol_id,int studentId, int courseId, int attendedDays, double grade) {
        this.enrol_id = enrol_id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.attendedDays = attendedDays;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getAttendedDays() {
        return attendedDays;
    }

    public void setAttendedDays(int attendedDays) {
        this.attendedDays = attendedDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getEnrol_id() {
        return enrol_id;
    }

    public void setEnrol_id(int enrol_id) {
        this.enrol_id = enrol_id;
    }
}
