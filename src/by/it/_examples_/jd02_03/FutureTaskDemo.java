package by.it._examples_.jd02_03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class FutureTaskDemo {

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        //в Java 8+ можно использовать лямбды
        //Callable<Integer> callTh = () -> { sleep(500); return 500; };
        Callable<Integer> callTh = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                sleep(500);
                return 500;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callTh);
        task.run();
        try {
            System.out.print("Result:" + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
