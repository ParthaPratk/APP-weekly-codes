class BankingTask implements Runnable {
    private String activity;
    private int delay;

    BankingTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - " + activity +
                " - Execution " + i
            );

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {

        BankingTask transaction =
            new BankingTask("Transaction Processing", 1000);

        BankingTask balance =
            new BankingTask("Balance Updating", 1500);

        BankingTask sms =
            new BankingTask("SMS Notification", 2000);

        Thread transactionThread = new Thread(transaction);
        Thread balanceThread = new Thread(balance);
        Thread smsThread = new Thread(sms);

        transactionThread.setName("Transaction Thread");
        balanceThread.setName("Balance Thread");
        smsThread.setName("SMS Thread");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}