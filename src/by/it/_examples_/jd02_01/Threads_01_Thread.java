package by.it._examples_.jd02_01;

class Threads_01_Thread {
    //пример показывает как можно создать потоки на базе класса Thread
    private static class MyThread extends Thread {
        @Override
        public void run() { //метод run должен обязательно быть у каждого потока
            for (int i = 0; i < 10; i++) { //это тело потока.
                System.out.println(this.getName()+"Цикл №"+i);
                try {
                    Thread.sleep((int)(Math.random()*1000)); // остановка на 0..999 миллисекунд
                    Thread.yield(); //так можно указать, что поток желает временно отдать
                                    //управление для выполнения других конкурентных потоков
                } catch (InterruptedException e) {
                    System.err.print(e.toString());
                }
            }
        }

        MyThread(String name) { //передаем имя суперклассу
            super(name);
        }
    }

    public static void main(String[ ] args) {
        new MyThread("-Первый поток. ").start();
        new MyThread("--Второй поток. ").start();
    }

}
