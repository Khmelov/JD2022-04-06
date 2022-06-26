package by.it.avramchuk.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.log("Hell");
        for (int i = 0; i < 10; i++) {
            new Worker().start();
        }
    }
}

    class Worker extends  Thread{
        @Override
        public void run() {
            Logger logger = Logger.getLogger();
            logger.log(this.getName());
        }
    }

