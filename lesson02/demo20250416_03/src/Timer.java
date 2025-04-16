import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TransferQueue;

public class Timer implements Runnable{

    private int timeOut = 1;

//    Cntr+Alt+V Ctrl+Alt+C

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(timeOut*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
