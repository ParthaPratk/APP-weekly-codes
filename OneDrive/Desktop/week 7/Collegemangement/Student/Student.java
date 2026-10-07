package Collegemangement.Student;

public class Student {
    String name;
    int id;
    String department;

    public Student(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Department: " + department);
    }
}