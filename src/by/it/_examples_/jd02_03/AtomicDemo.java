package by.it._examples_.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo extends Thread {

    private static final AtomicInteger serviceCount = new AtomicInteger(0);

    //целостная ссылка на состояние
    private static final AtomicReference<Phase> phase = new AtomicReference<>(Phase.NEW);

    public void run() {
        System.out.println("Step 0:" + phase);
        if (!phase.compareAndSet(Phase.NEW, Phase.INITIALIZING)) {
            throw new IllegalStateException("Already initialize");
        }
        System.out.printf("Step 1:%s\n", phase);
        Phase prev = phase.getAndSet(Phase.INITIALIZED);
        System.out.printf("Step 1:%s prev:%s\n", phase, prev);
        serviceCount.getAndAdd(1);
        System.out.printf("Number of started services %d\n", serviceCount.get());
    }

    public static void main(String[] args) throws InterruptedException {
        //чтобы не потерять потоки
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new AtomicDemo());
            threads.get(i).start();
        }
        for (Thread thread : threads) thread.join();
        System.out.println("atomicCount=" + serviceCount);
    }
}

enum Phase {
    NEW, INITIALIZING, INITIALIZED
}
