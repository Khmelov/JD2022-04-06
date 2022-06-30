package by.it.avramchuk.jd02_07;

import by.it.avramchuk.jd02_07.entity.Player;
import by.it.avramchuk.jd02_07.services.PlayerGeneratorTask;
import by.it.avramchuk.jd02_07.services.PlayerReaderTask;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) {

        PlayerGeneratorTask generatorTask = new PlayerGeneratorTask();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String> futurePath = executor.submit(generatorTask);
        try {
            System.out.println(futurePath.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        PlayerReaderTask readerTask = new PlayerReaderTask();
        Future<List<Player>> listFuture = executor.submit(readerTask);

        try {
            List<Player> list = listFuture.get();
            list.forEach(System.out::println);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
