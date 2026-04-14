import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("S2400553", "Sajal Pokharel", "sajal@example.com");
        Student student2 = new Student("S2400000", "Example One", "one@example.com");
        Student student3 = new Student("S2400111", "Example Two", "two@example.com");
        Student student4 = new Student("S2400222", "Example Three", "threeexample.com");

        // Create courses
        Course course1 = new Course("CS101", "Introduction to Programming", 2);
        Course course2 = new Course("CS000", "Example Subject", 1);

        // Display students
        System.out.println("========== STUDENT INFORMATION ==========");
        student1.displayStudentInfo();
        System.out.println();
        student2.displayStudentInfo();
        System.out.println();
        student3.displayStudentInfo();
        System.out.println();
        student4.displayStudentInfo();
        System.out.println();

        // Display courses
        System.out.println("========== COURSE DETAILS ==========");
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();

        // Create enrolments
        ArrayList<Enrolment> enrolments = new ArrayList<>();

        Enrolment e1 = new Enrolment(student1, course1, LocalDate.now());
        Enrolment e2 = new Enrolment(student2, course1, LocalDate.now());
        Enrolment e3 = new Enrolment(student3, course1, LocalDate.now()); // should go waitlist
        Enrolment e4 = new Enrolment(student4, course2, LocalDate.now());
        Enrolment e5 = new Enrolment(student1, course2, LocalDate.now()); // should go waitlist

        enrolments.add(e1);
        enrolments.add(e2);
        enrolments.add(e3);
        enrolments.add(e4);
        enrolments.add(e5);

        // Process enrolments
        System.out.println("========== ENROLMENT PROCESS ==========");
        for (Enrolment enrolment : enrolments) {
            enrolment.createEnrolment();
            System.out.println();
        }

        // Display enrolment details
        System.out.println("========== ENROLMENT DETAILS ==========");
        for (Enrolment enrolment : enrolments) {
            enrolment.displayEnrolmentDetails();
            System.out.println("--------------------------------------");
        }

        // Display course enrolment and waitlist
        System.out.println("========== COURSE 1 STATUS ==========");
        course1.displayCourseDetails();
        course1.displayEnrolledStudents();
        course1.displayWaitlist();
        System.out.println();

        System.out.println("========== COURSE 2 STATUS ==========");
        course2.displayCourseDetails();
        course2.displayEnrolledStudents();
        course2.displayWaitlist();
        System.out.println();

        // Demonstrate waitlist working
        System.out.println("========== TESTING WAITLIST FEATURE ==========");
        course1.removeStudent("S2400553"); // removing one enrolled student, next waitlisted student moves in
        System.out.println();

        System.out.println("========== UPDATED COURSE 1 STATUS ==========");
        course1.displayCourseDetails();
        course1.displayEnrolledStudents();
        course1.displayWaitlist();
    }
}