class TrafficJunction extends Thread {
    private String status;
    private int delay;

    TrafficJunction(String status, int delay) {
        this.status = status;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - Traffic Status: " + status +
                " - Report " + i
            );

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class SmartTrafficManagement {
    public static void main(String[] args) {

        TrafficJunction junction1 =
            new TrafficJunction("Heavy Traffic", 1000);

        TrafficJunction junction2 =
            new TrafficJunction("Moderate Traffic", 1500);

        TrafficJunction junction3 =
            new TrafficJunction("Low Traffic", 2000);

        junction1.setName("Junction 1");
        junction2.setName("Junction 2");
        junction3.setName("Junction 3");

        junction1.start();
        junction2.start();
        junction3.start();
    }
}