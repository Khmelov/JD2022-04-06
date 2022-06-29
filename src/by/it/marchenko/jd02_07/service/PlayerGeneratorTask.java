package by.it.marchenko.jd02_07.service;

import by.it.marchenko.jd02_07.constant.MessageConstant;
import by.it.marchenko.jd02_07.entity.Player;
import by.it.marchenko.jd02_07.util.FileName;
import by.it.marchenko.jd02_07.util.FilePathFounder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerGeneratorTask implements Callable<String>, MessageConstant {
    private static final AtomicInteger id = new AtomicInteger(NAME_ID_START_VALUE);
    private final Set<Player> players = new HashSet<>();

    private final FileName fileName = FileName.getInstance();

    @Override
    public String call() throws Exception {
        generatePlayers();
        return savePlayersToFile();
    }

    private void generatePlayers() {
        for (int i = 0; i < DEFAULT_COLLECTION_SIZE; i++) {
            Player player = generatePlayer();
            players.add(player);
        }
    }

    private Player generatePlayer() {
        String name = DEFAULT_PLAYER_NAME + String.format(ID_FORMAT, id.incrementAndGet());
        Integer age = ThreadLocalRandom.current().nextInt(MIN_AGE, MAX_AGE + 1);
        boolean status = Math.random() < 0.5;
        return new Player(name, age, status);
    }

    private String savePlayersToFile() {
        String file = fileName.getFileName();
        String playersFile = FilePathFounder.getFilePath(file);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(playersFile))) {
            for (Player player : players) {
                printWriter.println(player);
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return new File(playersFile).getName();
    }
}