import java.util.regex.Pattern;

public class Student {
    private String studentID;
    private String name;
    private String batch;
    private String department;
    private String password;

    public Student(String studentID, String name, String batch, String department, String password) {
        this.studentID = studentID;
        this.name = name;
        this.batch = batch;
        this.department = department;
        this.password = password;
    }

    public boolean validate() {
        // Validation rules
        boolean isValid = true;

        // Student ID validation
        isValid = isValid && Pattern.matches("[fF]\\d{8}", studentID);

        // Other fields not empty validation
        isValid = isValid && !name.isEmpty() && !batch.isEmpty() && !department.isEmpty() && !password.isEmpty();

        // Batch validation
        isValid = isValid && Pattern.matches("\\d{4}", batch);

        return isValid;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }
}
