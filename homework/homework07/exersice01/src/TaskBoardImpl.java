import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskBoardImpl implements TaskBoard {
    private final BlockingQueue<String> taskQueue;
    private final int maxQueueSize;

    public TaskBoardImpl(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
        this.taskQueue = new LinkedBlockingQueue<>(maxQueueSize);
    }

    @Override
    public void addTask(String task) throws InterruptedException {
        taskQueue.put(task);
    }

    @Override
    public String getTask() throws InterruptedException{
        return taskQueue.take();
    }
}