package by.it.kadulin.jd02_07;

import by.it.kadulin.jd02_07.service.PlayerGeneratorTask;
import by.it.kadulin.jd02_07.service.PlayerReaderTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConsoleRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            PlayerGeneratorTask plt = new PlayerGeneratorTask();
            plt.setFileName(String.valueOf(i));
            Future<String> submit = threadPool.submit(plt);
            PlayerReaderTask prt = new PlayerReaderTask();
            prt.setFileName(submit.get());
            prt.start();
        }
        threadPool.shutdown();
    }
}
