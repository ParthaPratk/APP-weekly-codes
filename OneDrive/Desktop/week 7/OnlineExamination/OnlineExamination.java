class ExamTask implements Runnable {
    private String activity;
    private int interval;

    ExamTask(String activity, int interval) {
        this.activity = activity;
        this.interval = interval;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - " + activity
            );

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {

        ExamTask timeTask =
            new ExamTask("Displaying remaining time", 1000);

        ExamTask saveTask =
            new ExamTask("Auto-saving student's answers", 1500);

        ExamTask networkTask =
            new ExamTask("Checking network connection", 2000);

        Thread timeThread = new Thread(timeTask);
        Thread saveThread = new Thread(saveTask);
        Thread networkThread = new Thread(networkTask);

        timeThread.setName("Time Thread");
        saveThread.setName("Auto-Save Thread");
        networkThread.setName("Network Thread");

        timeThread.start();
        saveThread.start();
        networkThread.start();
    }
}