import java.util.concurrent.atomic.AtomicLong;

public class LatencyMonitor {
    private final AtomicLong minLatency;

    public LatencyMonitor(AtomicLong minLatency) {
        this.minLatency = minLatency;
    }

    public AtomicLong getMinLatency() {
        return minLatency;
    }

    public LatencyMonitor() {
        minLatency = new AtomicLong(Long.MAX_VALUE);
    }

    public void updateLatency (double latency) {
        long latencyMillis = (long) latency;
        minLatency.updateAndGet(current -> Math.min(current, latencyMillis));
    }
}
