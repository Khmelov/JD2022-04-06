package by.it.marchenko.jd_02_06.TaskB;

import by.it.marchenko.jd_02_06.TaskB.Logger;

public class Runner {

    public static final String DEFAULT_THREAD_NAME = "ThreadName";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            InnerTester innerTester = new InnerTester(DEFAULT_THREAD_NAME + i);
            Thread thread = new Thread(innerTester);
            thread.start();
        }
    }

    private static class InnerTester implements Runnable {
        String name;

        private InnerTester(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Logger logger = Logger.get();
            if (Math.random() < 0.5) {
                logger.info("Some action with " + name);
            } else {
                logger.error("Something wrong with " + name);
            }
        }
    }
}
