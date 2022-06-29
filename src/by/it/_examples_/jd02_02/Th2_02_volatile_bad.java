package by.it._examples_.jd02_02;

public class Th2_02_volatile_bad {

    //переменная баланса
    private volatile static Integer balance=0;

    //это касса. Просто добавляет в баланс единицу
    static class Cashier extends Thread {
        //создадим видимость расчета
        int calc() {
            for (int i = 0; i < 666; i++) i = i + (int) (Math.sqrt(i / 1234.567));
            return 1;
        }
        @SuppressWarnings("NonAtomicOperationOnVolatileField")
        @Override
        public  void run() {
            //не будет работать. volatile - это ГАРАНТИЯ доступности, а не гарантия атомарности.
            balance += (calc());
        }
    }
    //создадим 6666 касс. Каждая добавит по 1. Сколько всего будет?
    public static void main(String[ ] args) {
        //Считаем сколько было потоков
        int thCount=Thread.activeCount();

        for (int i = 0; i < 6666; i++) {
            new Cashier().start();
        }
        //пока потоков больше чем было в начале просто ждем
        while (Thread.activeCount() > thCount) Thread.yield();
        System.out.print("Итого:"+balance);
    }
}
