import java.util.Scanner;

import student.Student;
import course.Course;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("COLLEGE MANAGEMENT SYSTEM");
        System.out.println("-------------------------");

        System.out.println("\nEnter Student Details");

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        System.out.println("\nEnter Course Details");

        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter course code: ");
        String courseCode = sc.nextLine();

        System.out.print("Enter number of credits: ");
        int credits = sc.nextInt();

        // Creating Student object
        Student student = new Student(
            studentName,
            rollNumber,
            department
        );

        Course course = new Course(
            courseName,
            courseCode,
            credits
        );

        student.displayStudentDetails();
        course.displayCourseDetails();

        sc.close();
    }
}