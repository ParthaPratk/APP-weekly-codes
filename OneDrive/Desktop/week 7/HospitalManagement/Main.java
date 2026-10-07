import java.util.Scanner;
import doctor.Doctor;
import doctor.patient.Patient;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Doctor 1 Details");
        System.out.print("Doctor ID: ");
        int d1Id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String d1Name = sc.nextLine();

        System.out.print("Specialization: ");
        String d1Spec = sc.nextLine();

        System.out.print("Consultation Fee: ");
        double d1Fee = sc.nextDouble();
        sc.nextLine();

        Doctor d1 = new Doctor(d1Id, d1Name, d1Spec, d1Fee);

        System.out.println("\nEnter Doctor 2 Details");
        System.out.print("Doctor ID: ");
        int d2Id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String d2Name = sc.nextLine();

        System.out.print("Specialization: ");
        String d2Spec = sc.nextLine();

        System.out.print("Consultation Fee: ");
        double d2Fee = sc.nextDouble();
        sc.nextLine();

        Doctor d2 = new Doctor(d2Id, d2Name, d2Spec, d2Fee);

        Patient[] patients = new Patient[3];
        Doctor[] assignedDoctors = new Doctor[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter Patient " + (i + 1) + " Details");

            System.out.print("Patient ID: ");
            int pId = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String pName = sc.nextLine();

            System.out.print("Disease: ");
            String disease = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            patients[i] = new Patient(pId, pName, disease, age);

            System.out.println("Choose Doctor:");
            System.out.println("1. " + d1.getName() + " - " + d1.getSpecialization());
            System.out.println("2. " + d2.getName() + " - " + d2.getSpecialization());
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                assignedDoctors[i] = d1;
            } else {
                assignedDoctors[i] = d2;
            }
        }

        System.out.println("\n===== PATIENT AND DOCTOR DETAILS =====");

        int doctor1Patients = 0;
        int doctor2Patients = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("\nPatient " + (i + 1));
            patients[i].display();

            System.out.println("\nDoctor Treating Patient:");
            assignedDoctors[i].display();

            if (assignedDoctors[i] == d1) {
                doctor1Patients++;
            } else {
                doctor2Patients++;
            }
        }

        double total1 = doctor1Patients * d1.getConsultationFee();
        double total2 = doctor2Patients * d2.getConsultationFee();

        System.out.println("\n===== TOTAL CONSULTATION FEE =====");

        System.out.println(d1.getName() + ": " + total1);
        System.out.println(d2.getName() + ": " + total2);

        sc.close();
    }
}