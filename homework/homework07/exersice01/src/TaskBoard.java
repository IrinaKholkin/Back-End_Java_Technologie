public interface TaskBoard {

    void addTask(String task) throws InterruptedException;
    String getTask() throws InterruptedException;
}
