package by.it.arsenihlaz.jd02_06;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Worker("thread " + i).start();
        }
    }
}

class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger logger = Logger.getInstance();
        logger.info("successfully completed " + getName());
        logger.error("NullPointerException " + getName());
    }
}
