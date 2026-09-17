package student;

public class Student {

    String name;
    int rollNumber;
    String department;

    public Student(String name, int rollNumber, String department) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
    }

    public void displayStudentDetails() {

        System.out.println("\n--- Student Details ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Department : " + department);
    }
}