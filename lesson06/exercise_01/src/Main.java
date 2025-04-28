import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111","Jack", 1000);
        Account accountB = new Account("DE2222","John", 1000);

        Thread thread1 = new Thread(() -> {
            try {
                transfer(accountA, accountB, 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T1");
        Thread thread2 = new Thread(() -> {
            try {
                transfer(accountB, accountA, 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T2");

        Thread lockMonitor = new DeadlockDetector();

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);
    }

    public static void transfer(Account from, Account to, double amount) throws InterruptedException {
        Account first =from.hashCode()<to.hashCode()? from: to;
        Account second=from.hashCode()<to.hashCode()? to: from;
        try {
            if (first.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println("account " + from + " is locked by " + Thread.currentThread().getName());
                    if (second.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("account " + to + " is locked by" + Thread.currentThread().getName());
                            if (from.withdraw(amount)) {
                                to.deposit(amount);
                                System.out.println("Transfer of " + amount + " completed successfully");
                            } else {
                                System.out.println("Insufficient funds for transfer");
                        }
                    } finally {
                            second.unlock();
                            System.out.println("Account " + second + " is unlocked");
                        }
                        }else {
                        System.out.println("Could not acquire on second account, transfer aborted");
                    }
                } finally {
                    first.unlock();
                    System.out.println("Account " + first + " is unlocked");
                }
                } else {
                System.out.println("Could not acquire on first account, transfer aborted");
            }
             } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted during transfer");
        }
        System.out.println("Transfer operation finished");
        }
}




