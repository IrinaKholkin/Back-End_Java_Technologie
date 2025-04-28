public class Worker implements Runnable {
    private TaskBoard taskBoard;
    private String name;

    public Worker(TaskBoard taskBoard, String name) {
        this.taskBoard = taskBoard;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String task = taskBoard.getTask();
                System.out.println(task + " " + name);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + "interrupted");
        }
    }
}