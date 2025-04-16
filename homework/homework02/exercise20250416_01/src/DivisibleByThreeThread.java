public class DivisibleByThreeThread extends Thread{
    private boolean running = true;

    public void stopRunning() {
        running = false;
    }

    @Override
    public void run() {
        int i = 1;
        while (running) {
            if (i % 3 == 0) {
                System.out.println("Делится на 3: " + i );
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
