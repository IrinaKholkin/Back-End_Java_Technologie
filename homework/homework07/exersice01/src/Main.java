public class Main {
    private final static int N_TASKS=20;
    private final static int N_WORKERS=3;
    private final static int MAX_QUEUE_SIZE=5;


    public static void main(String[] args) throws InterruptedException {
        TaskBoard taskBoard = new TaskBoardImpl(MAX_QUEUE_SIZE);

        Thread manager = new Thread(new Manager(taskBoard, N_TASKS));

        Thread[] workers = new Thread[N_WORKERS];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(new Worker(taskBoard,"worker-"+i)   );
            workers[i].setDaemon(true);
            workers[i].start();
        }

        manager.start();
        manager.join();

        Thread.sleep(1000);
    }
}