package by.it._examples_.jd02_02;

@SuppressWarnings("all") //demo
class Th2_07_bad_producer_consumer {
    private static int itemCount = 0;
    private static final int MAX_SIZE = 10;
    private static int counter = 100000;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static void stopIt(Object object) {
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void wakeUp(Object object) {
        synchronized (object) {
            object.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        producer.start();
        consumer.start();
        Thread.sleep(1000);
        System.out.println("producer consumer");
        System.out.println(producer.getState() + "  " + consumer.getState());
    }

    private static class Producer extends Thread {
        @Override
        public void run() {
            while (counter > 0) {
                if (itemCount == MAX_SIZE)
                    stopIt(producer);
                // addItem();
                itemCount++;
                if (itemCount == 1)
                    wakeUp(consumer);
                System.out.println("Producer:" + itemCount);
            }
        }
    }


    private static class Consumer extends Thread {
        @Override
        public void run() {
            while (counter > 0) {
                if (itemCount == 0)
                    stopIt(consumer);
                // removeItem();
                itemCount--;
                counter--;
                if (itemCount == MAX_SIZE - 1)
                    wakeUp(producer);
                System.out.println("Consumer:" + itemCount);
            }
        }
    }
}

