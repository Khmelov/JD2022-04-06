package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.utils.Filter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static by.it.smirnov.jd02_07.constants.Constants.MAX_POOL;

public class ThreadsPool extends Thread {

    private ExecutorService threadPool;

    @Override
    public void run() {
        threadPool = Executors.newFixedThreadPool(MAX_POOL);
        for (int i = 0; i < 20; i++) {
            PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask();
            playerGeneratorTask.start();
        }
        threadPool.shutdown();
        waitTermination();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Filter.printFiltered(PlayerReaderTask.playersChosen);
    }

    private void waitTermination() {
        try {
            do {
                Thread.onSpinWait();
            } while (!threadPool.awaitTermination(1, TimeUnit.MINUTES));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
