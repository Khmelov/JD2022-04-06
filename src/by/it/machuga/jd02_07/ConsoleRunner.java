package by.it.machuga.jd02_07;

import by.it.machuga.jd02_07.entity.Player;
import by.it.machuga.jd02_07.servise.PlayerGeneratorTask;
import by.it.machuga.jd02_07.servise.PlayerReaderTask;
import by.it.machuga.jd02_07.interfaces.Constants;
import by.it.machuga.jd02_07.util.Printer;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ConsoleRunner {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Player> allPlayers = new CopyOnWriteArrayList<>();
        processPlayers(allPlayers);
        List<Player> topFive = getTopPlayers(allPlayers);
        printNamesUpperCase(topFive);
    }

    private static void processPlayers(CopyOnWriteArrayList<Player> allPlayers) {
        ExecutorService executors = Executors.newFixedThreadPool(Constants.POOL_SIZE);
        for (int i = 0; i < Constants.NUMBER_THREADS; i++) {
            try {
                List<Player> filteredPlayers = startPlayersProcess(executors);
                allPlayers.addAll(filteredPlayers);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
    }

    private static List<Player> startPlayersProcess(ExecutorService executors) throws ExecutionException,
            InterruptedException {
        String fileName = producePlayers(executors);
        return filterPlayers(executors, fileName);
    }

    private static String producePlayers(ExecutorService executors) throws InterruptedException, ExecutionException {
        PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask(Constants.PLAYERS_COUNT);
        Future<String> fileNameFuture = executors.submit(playerGeneratorTask);
        return fileNameFuture.get();
    }

    private static List<Player> filterPlayers(ExecutorService executors, String fileName) throws InterruptedException,
            ExecutionException {
        PlayerReaderTask playerReaderTask = new PlayerReaderTask(fileName);
        Future<List<Player>> playersFuture = executors.submit(playerReaderTask);
        return playersFuture.get();
    }

    private static List<Player> getTopPlayers(CopyOnWriteArrayList<Player> allPlayers) {
        return allPlayers.stream()
                .sorted(Comparator.comparingInt(Player::getAge))
                .limit(Constants.TOP_SIZE)
                .collect(Collectors.toList());
    }

    private static void printNamesUpperCase(List<Player> topFive) {
        Printer.printNames(topFive);
    }
}
