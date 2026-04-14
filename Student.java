public class Student {
    // Private attributes for encapsulation
    private String studentId;
    private String name;
    private String email;

    // Constructor
    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name      : " + name);
        System.out.println("Email     : " + email);
    }
}