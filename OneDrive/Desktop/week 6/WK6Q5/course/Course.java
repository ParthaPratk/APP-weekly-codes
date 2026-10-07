package course;

public class Course {

    String courseName;
    String courseCode;
    int credits;

    public Course(String courseName, String courseCode, int credits) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public void displayCourseDetails() {

        System.out.println("\n--- Course Details ---");
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credits    : " + credits);
    }
}