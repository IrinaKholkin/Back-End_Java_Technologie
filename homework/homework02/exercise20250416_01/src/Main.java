public class Main {
    public static void main(String[] args) {
        DivisibleByTwoThread thread1 = new DivisibleByTwoThread();
        DivisibleByThreeThread thread2 = new DivisibleByThreeThread();

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread1.stopRunning();
        thread2.stopRunning();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Программа завершена");
    }
}