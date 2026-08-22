import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    double calculateSalary() {
        return salary;
    }
}

class Professor extends Employee {
    Professor(String name, int id, double salary) {
        super(name, id, salary);
    }

    double calculateSalary() {
        return salary + 5000;
    }
}

class LabAssistant extends Employee {
    LabAssistant(String name, int id, double salary) {
        super(name, id, salary);
    }

    double calculateSalary() {
        return salary + 3000;
    }
}

class AdministrativeStaff extends Employee {
    AdministrativeStaff(String name, int id, double salary) {
        super(name, id, salary);
    }

    double calculateSalary() {
        return salary + 2000;
    }
}

public class UniversityEmployee{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Professor name: ");
        String n1 = sc.nextLine();

        System.out.print("Enter Professor ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Professor basic salary: ");
        double s1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nEnter Lab Assistant name: ");
        String n2 = sc.nextLine();

        System.out.print("Enter Lab Assistant ID: ");
        int id2 = sc.nextInt();

        System.out.print("Enter Lab Assistant basic salary: ");
        double s2 = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nEnter Administrative Staff name: ");
        String n3 = sc.nextLine();

        System.out.print("Enter Administrative Staff ID: ");
        int id3 = sc.nextInt();

        System.out.print("Enter Administrative Staff basic salary: ");
        double s3 = sc.nextDouble();

        Employee p = new Professor(n1, id1, s1);
        Employee l = new LabAssistant(n2, id2, s2);
        Employee a = new AdministrativeStaff(n3, id3, s3);

        System.out.println("\n--- Employee Salaries ---");
        System.out.println("Professor Salary: " + p.calculateSalary());
        System.out.println("Lab Assistant Salary: " + l.calculateSalary());
        System.out.println("Administrative Staff Salary: " + a.calculateSalary());

        sc.close();
    }
}