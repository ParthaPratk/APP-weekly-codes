import java.util.Scanner;

class EmergencyAlert extends Thread {
    private int cycles;

    EmergencyAlert(int cycles) {
        this.cycles = cycles;
        setName("EmergencyAlert");
        setPriority(Thread.MAX_PRIORITY); // 10
    }

    public void run() {
        for (int i = 1; i <= cycles; i++) {
            System.out.println(getName() + " - Priority: " + getPriority()
                    + " - Critical patient alert " + i);
        }
    }
}

class VitalMonitor extends Thread {
    private int cycles;

    VitalMonitor(int cycles) {
        this.cycles = cycles;
        setName("VitalMonitor");
        setPriority(Thread.NORM_PRIORITY); // 5
    }

    public void run() {
        for (int i = 1; i <= cycles; i++) {
            System.out.println(getName() + " - Priority: " + getPriority()
                    + " - Checking vital signs " + i);
        }
    }
}

class ReportGenerator extends Thread {
    private int cycles;

    ReportGenerator(int cycles) {
        this.cycles = cycles;
        setName("ReportGenerator");
        setPriority(Thread.MIN_PRIORITY); // 1
    }

    public void run() {
        for (int i = 1; i <= cycles; i++) {
            System.out.println(getName() + " - Priority: " + getPriority()
                    + " - Generating routine report " + i);
        }
    }
}

public class HospitalEmergencyMonitoring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of monitoring cycles: ");
        int cycles = sc.nextInt();

        EmergencyAlert emergency = new EmergencyAlert(cycles);
        VitalMonitor vital = new VitalMonitor(cycles);
        ReportGenerator report = new ReportGenerator(cycles);

        System.out.println("\nThread Details:");
        System.out.println(emergency.getName() + " - Priority: "
                + emergency.getPriority());
        System.out.println(vital.getName() + " - Priority: "
                + vital.getPriority());
        System.out.println(report.getName() + " - Priority: "
                + report.getPriority());

        System.out.println("\n--- Thread Execution ---");

        emergency.start();
        vital.start();
        report.start();

        sc.close();
    }
}