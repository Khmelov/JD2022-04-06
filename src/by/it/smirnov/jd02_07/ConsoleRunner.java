package by.it.smirnov.jd02_07;

import by.it.smirnov.jd02_07.threads.ThreadsPool;

public class ConsoleRunner {

    public static void main(String[] args) {
        ThreadsPool threadsPool = new ThreadsPool();
        threadsPool.start();
    }
}
