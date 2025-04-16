public class MyRunnable implements Runnable{
//второй вариант создания потока
//    1. Реализуем Runnable
//    2. Создаем new Thread(runnable)
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(" (i) Thread" + name + "start");
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(" (i) Thread " + name + " finish");
    }
}
