import java.time.LocalDate;

public class Enrolment {
    // Private attributes
    private Student student;
    private Course course;
    private LocalDate enrolmentDate;
    private boolean enrolledSuccessfully;

    // Constructor
    public Enrolment(Student student, Course course, LocalDate enrolmentDate) {
        this.student = student;
        this.course = course;
        this.enrolmentDate = enrolmentDate;
        this.enrolledSuccessfully = false;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public boolean isEnrolledSuccessfully() {
        return enrolledSuccessfully;
    }

    // Setters
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    // Create enrolment
    public void createEnrolment() {
        enrolledSuccessfully = course.addStudent(student);
    }

    // Display enrolment details
    public void displayEnrolmentDetails() {
        System.out.println("Student Name   : " + student.getName());
        System.out.println("Student ID     : " + student.getStudentId());
        System.out.println("Course Code    : " + course.getCourseCode());
        System.out.println("Course Name    : " + course.getCourseName());
        System.out.println("Enrolment Date : " + enrolmentDate);

        if (enrolledSuccessfully) {
            System.out.println("Status         : Enrolled");
        } else {
            System.out.println("Status         : Waitlisted");
        }
    }
}