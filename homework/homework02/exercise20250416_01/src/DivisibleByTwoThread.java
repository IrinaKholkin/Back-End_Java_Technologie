public class DivisibleByTwoThread extends Thread{
private boolean running = true;

public void stopRunning() {
    running = false;
}
    @Override
    public void run() {
        int i =1;
        while (running) {
            if (i % 2 == 0) {
                System.out.println("Делится на 2: " + i);
            }
            i++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

