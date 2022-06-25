package by.it.smirnov.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Hello");
        for (int i = 0; i < 10; i++) {
            new Worker("Super-Worker" + i).start();
        }
    }
}

class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger.getInstance().log(this.getName());
    }
}