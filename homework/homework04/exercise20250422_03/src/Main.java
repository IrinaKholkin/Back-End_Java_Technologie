public class Main {
//    Класс Account является не потокобезопасным,
//    т.е. если вызывать методы этого класса напрямую,
//    минуя метод transfer из разных потоков - мы получим проблемы. Ваша задача,
//    сделать этот класс потокобезлпасным.

    public static void main(String[] args) throws InterruptedException {

        Account accountA = new Account("DE1111","Jack", 1000);
        Account accountB = new Account("DE2222","John", 1000);
        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 300), "T1");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 500), "T2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);
    }
    public static void transfer(Account from, Account to, double amount){
        Account firstLock = from.getIban().compareTo(to.getIban()) < 0 ? from : to;
        Account secondLock = firstLock == from ? to : from;
        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
    }
}
