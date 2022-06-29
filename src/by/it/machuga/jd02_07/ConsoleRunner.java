package by.it.machuga.jd02_07;

import by.it.machuga.jd02_07.servise.PlayerGeneratorTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsoleRunner {
    public static void main(String[] args) {
        PlayerGeneratorTask playerGeneratorTask=new PlayerGeneratorTask();
        ExecutorService executors=Executors.newFixedThreadPool(4);
        executors.submit(playerGeneratorTask);
        executors.shutdown();
    }
}
