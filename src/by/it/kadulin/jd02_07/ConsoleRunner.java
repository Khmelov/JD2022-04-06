package by.it.kadulin.jd02_07;

import by.it.kadulin.jd01_14.TaskA;
import by.it.kadulin.jd01_14.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsoleRunner {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 20; i++) {
//            PlayerGeneratorTask plt = new PlayerGeneratorTask();
//            plt.setNameThread("Thread" + i);
//            threadPool.submit(plt);
//        }
//        threadPool.shutdown();
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            PlayerGeneratorTask plt = new PlayerGeneratorTask();
            plt.setNameThread("Thread" + i);
            plt.start();
            threadList.add(plt);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Thread thread : threadList) {
            if (thread.getState() == Thread.State.TERMINATED) {
                PlayerReaderTask prt = new PlayerReaderTask();
                prt.setThread(thread);
                prt.start();
            }
        }



    }
}
