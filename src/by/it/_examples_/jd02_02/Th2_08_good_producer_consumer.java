package by.it._examples_.jd02_02;

class Th2_08_good_producer_consumer {
    private static int itemCount = 0;
    private static final int MAX_SIZE = 10;
    private static int counter = 100000;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();


    public static void main(String[] args) {
        producer.start();
        consumer.start();
        while (consumer.getState()!= Thread.State.TERMINATED)
            Thread.yield();
        System.out.println("producer consumer");
        System.out.println(producer.getState() + "  " + consumer.getState());
    }

    private static class Producer extends Thread {
        @Override
        public void run() {
            while (counter > 0) {
                synchronized (this) {
                    if (itemCount == MAX_SIZE) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (consumer) {
                    // addItem();
                    itemCount++;
                    if (itemCount == 1)
                        consumer.notify();
                }
                System.out.println("Producer:" + itemCount);
            }
        }
    }


    private static class Consumer extends Thread {
        @Override
        public void run() {
            while (counter > 0) {
                synchronized (this) {
                    if (itemCount == 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (producer) {
                    // removeItem();
                    itemCount--;
                    counter--;
                    if (itemCount == MAX_SIZE - 1)
                        producer.notify();
                }
                System.out.println("Consumer:" + itemCount);
            }
        }
    }
}

