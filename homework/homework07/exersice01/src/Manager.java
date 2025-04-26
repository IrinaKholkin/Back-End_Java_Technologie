public class Manager implements Runnable{
    private  TaskBoard taskBoard;
    private int nTasks;

    public Manager(TaskBoard taskBoard, int nTasks) {
        this.taskBoard = taskBoard;
        this.nTasks = nTasks;
    }

    @Override
    public void run() {
        for (int i = 0; i < nTasks; i++) {
            String task = "task-" + i;
            try {
                taskBoard.addTask(task);
                System.out.println("Manager added: " + task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Manager interrupted");
            }
        }
    }

}
