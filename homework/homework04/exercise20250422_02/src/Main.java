//Компания разрабатывает систему мониторинга производительности веб-сервисов.
// Один из важных показателей — минимальная задержка ответа (latency) от сервера.
// Нужно реализовать компонент LatencyMonitor, который отслеживает самое минимальное время отклика,
// полученное из множества параллельных потоков, поступающих от разных серверов/кластеров.
// Задержка - случайное целое число (мс), в диапазоне от 0 до Integer.MAX_VALUE.
// Каждый из N потоков-серверов генерирует это число и вызывает метод updateLatency(double latency)
// класса LatencyMonitor. Реализация не должна использовать synchronized или блокировки
// — только атомарные структуры (Atomic*).

public class Main {
    public static void main(String[] args) {
        LatencyMonitor monitor = new LatencyMonitor();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                double randomLatency = Math.random() * Integer.MAX_VALUE;
                monitor.updateLatency(randomLatency);
            }
        };
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Минимальная задержка: " + monitor.getMinLatency() + " мс");
        }
    }
}