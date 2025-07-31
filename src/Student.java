import java.io.Reader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private char gender;
//    public Student(){
//        List<String[]> listStudents = CSVReader.read("D://Courses//Chad_Darby_Java_DB_Connection//test_jdbc//students.csv");
//    }

    public Student(int id, String firstName, String lastName, LocalDate birthDate,
                   String phone, String email, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

}
