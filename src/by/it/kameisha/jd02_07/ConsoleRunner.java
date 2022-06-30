package by.it.kameisha.jd02_07;

import by.it.kameisha.jd02_07.util.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConsoleRunner {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        ArrayList<Future<String>> futurePaths = new ArrayList<>();
        ArrayList<Future<List<Player>>> futurePlayerLists = new ArrayList<>();
        ArrayList<Player> newPlayerList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String path = Util.getPath(ConsoleRunner.class, "repository" + File.separator + "playerList" + i + ".txt");
            futurePaths.add(pool.submit(new PlayerGeneratorTask(path)));
        }
        for (Future<String> path : futurePaths) {
            if (path.isDone()) {
                try {
                    futurePlayerLists.add(pool.submit(new PlayerReaderTask(path.get())));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                Thread.onSpinWait();
            }
        }
        for (Future<List<Player>> playerList : futurePlayerLists) {
            if (playerList.isDone()) {
                try {
                    newPlayerList.addAll(playerList.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Thread.onSpinWait();
            }
        }
        pool.shutdown();
        for (Player player : newPlayerList) {
            System.out.println(player.toString());
        }
    }
}