package by.it.machuga.jd02_06;

public class Runner {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.error(Constants.TEST_ERROR_MSG);
        for (int i = 0; i < 10; i++) {
            new Worker(Constants.THREAD + i).start();
        }
    }
}

class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger.getInstance().info(this.getName());
    }
}