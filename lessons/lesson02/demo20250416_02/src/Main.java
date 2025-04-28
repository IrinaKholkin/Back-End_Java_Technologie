public class Main {
    public static void main(String[] args) throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        Long id = Thread.currentThread().getId();
        System.out.println(id);
        System.out.println( name + " " + id + " START");

//        создание Thread через анонимный класс
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() + " START анонимный класс");
            }
        };

        Thread[] treads = {
                new MyThread(),
                new MyThread(),
                new Thread(new MyRunnable()),
                new Thread(()->{ System.out.println( Thread.currentThread().getName() + " START LAMBDA"); }),
                thread1
        };

        for (Thread tread: treads) {
            tread.start();
        }
        for (Thread tread: treads) {
            tread.join();
        }

        Thread.sleep(1000);
        System.out.println(name + " " + id + " FINISH");
    }
}