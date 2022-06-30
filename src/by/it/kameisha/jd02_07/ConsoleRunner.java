package by.it.kameisha.jd02_07;

import by.it.kameisha.jd02_07.util.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConsoleRunner {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        ArrayList<Future<String>> paths = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String path = Util.getPath(ConsoleRunner.class, "repository" + File.separator + "playerList" + i + ".txt");
            paths.add(pool.submit(new PlayerGeneratorTask(path)));
        }
        while (pool.isTerminated()) {
            for (Future<String> path : paths) {
                if (path.isDone()) {
                    try {
                        System.out.println("поток завершен");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("поток не завершен");
                }
            }
        }
        pool.shutdown();
    }
}