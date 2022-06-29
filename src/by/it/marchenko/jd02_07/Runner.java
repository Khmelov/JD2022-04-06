package by.it.marchenko.jd02_07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static final int MAX_THREAD = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);
    }
}
