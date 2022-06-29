package by.it._examples_.jd02_01;

class Threads_04_Join {
    private static class JoinThread extends Thread {

        public JoinThread(String name) {
            super(name);
        }

        public void run() {
            String nameT = getName();
            System.out.println("Старт потока " + nameT);
            try {
                long timeout = switch (nameT) {
                    case "First" -> 5_000;
                    case "Second" -> 4_000;
                    default -> 0;
                };
                Thread.sleep(timeout);
                System.out.println("завершение потока " + nameT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //============================================================
    public static void main(String[] args) {
        System.out.println("Старт потока main");
        JoinThread t1 = new JoinThread("First");
        JoinThread t2 = new JoinThread("Second");
        t1.start();
        t2.start();
        try {
            t2.join(); // поток main остановлен до окончания работы потока t1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()); // имя текущего потока
    }

}
