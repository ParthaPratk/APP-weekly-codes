package Collegemangement;

import Collegemangement.Course.Course;
import Collegemangement.Student.Student;

public class Main {
    public static void main(String[] args) {

        Student s = new Student("Partha", 101, "Computer Science");
        Course c = new Course("Data Structures", "CS201", 4);

        System.out.println("Student Information");
        s.displayStudent();

        System.out.println();

        System.out.println("Course Information");
        c.displayCourse();
    }
}