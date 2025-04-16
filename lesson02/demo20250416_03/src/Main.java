import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Timer timer = new Timer();
        Thread thread = new Thread(timer);

        thread.setDaemon(true);
        thread.start();

        while (true) {
            System.out.println("Input time-out or press r for stop");
            String str = scanner.nextLine();
            if (str.equals("r")) {
                break;
            } else {
                try {
                    timer.setTimeOut(Integer.parseInt(str));
                } catch (Exception e) {
                    timer.setTimeOut(3);
                }
            }
        }
        System.out.println("Main finish");

    }
}