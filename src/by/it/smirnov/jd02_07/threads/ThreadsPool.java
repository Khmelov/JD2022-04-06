package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.entity.Player;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsPool extends Thread {

    private ExecutorService threadPool;

    @Override
    public void run() {
        threadPool = Executors.newFixedThreadPool(4);
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
        Object[] first5 = PlayerReaderTask.playersChosen.stream()
                .sorted(Comparator.comparing(Player::getAge))
                .limit(5)
                .toArray();
        for (Object o : first5) {
            Player player = (Player) o;
            System.out.println(player.name);
        }
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
