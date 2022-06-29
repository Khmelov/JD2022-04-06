package by.it.marchenko.jd02_07.service;

import by.it.marchenko.jd02_07.constant.MessageConstant;
import by.it.marchenko.jd02_07.entity.Player;

import java.util.*;
import java.util.concurrent.*;

public class PlayerFounder implements MessageConstant {

    private static final Set<Future<String>> futureFiles = new HashSet<>();

    public List<String> findTopPlayer() {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_PARALLEL_THREAD);
        startPlayerGeneratorTask(executorService);
        Queue<Player> players = selectPlayers(executorService);
        terminateAllThreads(executorService);
        return findTopYoungest(players);
    }

    private static void startPlayerGeneratorTask(ExecutorService executorService) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Callable<String> generatorThread = new PlayerGeneratorTask();
            Future<String> fileName = executorService.submit(generatorThread);
            futureFiles.add(fileName);
        }
    }

    private static Queue<Player> selectPlayers(ExecutorService executorService) {
        ConcurrentLinkedQueue<Player> allSelectedPlayers = new ConcurrentLinkedQueue<>();
        for (Future<String> futureFile : futureFiles) {
            try {
                Callable<Set<Player>> findPlayersThread = new PlayerReaderTask(futureFile.get());
                Set<Player> selectedPlayers = executorService.submit(findPlayersThread).get();
                allSelectedPlayers.addAll(selectedPlayers);

            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(PARALLEL_THREADS_EXCEPTION_MESSAGE, e);
            }
        }
        return allSelectedPlayers;
    }

    private void terminateAllThreads(ExecutorService executorService) {
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.onSpinWait();
        }
    }

    private List<String> findTopYoungest(Queue<Player> players) {
        return players.stream().sorted().
                map(Player::getName).
                limit(TOP_LIMIT).
                map(String::toUpperCase).
                toList();
    }
}
