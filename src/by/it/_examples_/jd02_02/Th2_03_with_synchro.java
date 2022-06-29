package by.it._examples_.jd02_02;

public class Th2_03_with_synchro {

    //переменная баланса
    private static Integer balance=0;

    //это касса. Просто добавляет в баланс единицу
    static class Cashier extends Thread {
        //создадим видимость расчета
        int calc() {
            for (int i = 0; i < 666; i++) i = i + (int) (Math.sqrt(i / 1234.567));
            return 1;
        }
        @Override
        public  void run() {
            //noinspection SynchronizeOnNonFinalField
            synchronized (balance) {
                //Удивительно, но и это не будет работать
                balance += (calc());
                //Почему? Потому, что нельзя базировать синхронизатор на изменяемом поле.
                //Есть шанс потерять монитор, а с ним и синхронизацию
            }
        }
    }
    //создадим 4444 касс. Каждая добавит по 1. Сколько всего будет?
    public static void main(String[ ] args) {
        //Считаем сколько было потоков
        int thCount=Thread.activeCount();

        for (int i = 0; i < 4444; i++) {
            new Cashier().start();
        }
        //пока потоков больше чем было в начале просто ждем
        while (Thread.activeCount() > thCount) Thread.yield();
        System.out.print("Итого:"+balance);
    }
}
