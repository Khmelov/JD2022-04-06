package by.it.kameisha.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Hello");
        for (int i = 0; i < 10; i++) {
            new Worker("Worker №" + i).start();
        }
    }
}
