import java.util.Scanner;

class OrderProcessing extends Thread {

    private int tasks;

    OrderProcessing(int tasks) {
        this.tasks = tasks;
        setName("OrderProcessing");
        setPriority(Thread.MAX_PRIORITY);   // Priority 10
    }

    public void run() {
        for (int i = 1; i <= tasks; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Processing customer order " + i);
        }
    }
}

class DeliveryTracking extends Thread {

    private int tasks;

    DeliveryTracking(int tasks) {
        this.tasks = tasks;
        setName("DeliveryTracking");
        setPriority(Thread.NORM_PRIORITY);  // Priority 5
    }

    public void run() {
        for (int i = 1; i <= tasks; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Tracking delivery location " + i);
        }
    }
}

class Notification extends Thread {

    private int tasks;

    Notification(int tasks) {
        this.tasks = tasks;
        setName("Notification");
        setPriority(Thread.MIN_PRIORITY);   // Priority 1
    }

    public void run() {
        for (int i = 1; i <= tasks; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Sending order-status notification " + i);
        }
    }
}

public class FoodDeliveryMultithreading {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks for each thread: ");
        int tasks = sc.nextInt();

        OrderProcessing order = new OrderProcessing(tasks);
        DeliveryTracking delivery = new DeliveryTracking(tasks);
        Notification notification = new Notification(tasks);

        System.out.println("\nThread Details:");
        System.out.println(order.getName() + " - Priority: "
                + order.getPriority());
        System.out.println(delivery.getName() + " - Priority: "
                + delivery.getPriority());
        System.out.println(notification.getName() + " - Priority: "
                + notification.getPriority());

        System.out.println("\n--- Concurrent Execution ---");

        order.start();
        delivery.start();
        notification.start();

        sc.close();
    }
}