public class Loader implements Runnable {
    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private int done = 0;

    public Loader(String name, int nBox, int capacity, Warehouse warehouse1, Warehouse warehouse2) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse1 = warehouse1;
        this.warehouse2 = warehouse2;
    }

    @Override
    public void run() {
        while (done < nBox) {
            int boxesToTake = Math.min(nBox - done, capacity);
            synchronized (warehouse1) {
                synchronized (warehouse2) {
                    if (boxesToTake >= 1) {
                        warehouse1.addValue(1);
                    }
                    if (boxesToTake >= 2) {
                        warehouse2.addValue(1);
                    }
                    done += boxesToTake;
                }
            }
            try {
                Thread.sleep(5 + (int) (Math.random() * 10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " finish. Total delivered: " + done + " boxes");
    }
}
