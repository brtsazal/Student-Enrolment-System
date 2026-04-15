import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course {
    // Private attributes
    private String courseCode;
    private String courseName;
    private int maximumCapacity;

    // List of enrolled students
    private List<Student> enrolledStudents;

    // Waitlist queue for students if course is full
    private Queue<Student> waitlist;

    // Constructor
    public Course(String courseCode, String courseName, int maximumCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maximumCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Queue<Student> getWaitlist() {
        return waitlist;
    }

    // Setters
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    // Check whether course is full
    public boolean isFull() {
        return enrolledStudents.size() >= maximumCapacity;
    }

    // Enrol student or add to waitlist if full
    public boolean addStudent(Student student) {
        // Avoid duplicate enrolment
        for (Student s : enrolledStudents) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println(student.getName() + " is already enrolled in " + courseCode + ".");
                return true;
            }
        }

        // Avoid duplicate waitlist entry
        for (Student s : waitlist) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println(student.getName() + " is already in the waitlist for " + courseCode + ".");
                return false;
            }
        }

        if (!isFull()) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " enrolled successfully in " + courseCode + ".");
            return true;
        } else {
            waitlist.offer(student);
            System.out.println("Course " + courseCode + " is full.");
            System.out.println(student.getName() + " has been added to the waitlist.");
            return false;
        }
    }

    // Remove a student from enrolled list
    public boolean removeStudent(String studentId) {
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getStudentId().equals(studentId)) {
                Student removedStudent = enrolledStudents.remove(i);
                System.out.println(removedStudent.getName() + " has been removed from " + courseCode + ".");

                // Move next waitlisted student into enrolled list
                if (!waitlist.isEmpty()) {
                    Student nextStudent = waitlist.poll();
                    enrolledStudents.add(nextStudent);
                    System.out.println(nextStudent.getName() + " has been moved from waitlist to enrolled list in " + courseCode + ".");
                }
                return true;
            }
        }

        System.out.println("Student with ID " + studentId + " is not enrolled in " + courseCode + ".");
        return false;
    }

    // Display course details
    public void displayCourseDetails() {
        System.out.println("Course Code     : " + courseCode);
        System.out.println("Course Name     : " + courseName);
        System.out.println("Maximum Capacity: " + maximumCapacity);
        System.out.println("Enrolled Count  : " + enrolledStudents.size());
        System.out.println("Waitlist Count  : " + waitlist.size());
    }

    // Display enrolled students
    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students in " + courseCode + ":");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getStudentId() + " | " + student.getName());
            }
        }
    }

    // Display waitlist students
    public void displayWaitlist() {
        System.out.println("Waitlist for " + courseCode + ":");
        if (waitlist.isEmpty()) {
            System.out.println("No students in waitlist.");
        } else {
            for (Student student : waitlist) {
                System.out.println("- " + student.getStudentId() + " | " + student.getName());
            }
        }
    }
}