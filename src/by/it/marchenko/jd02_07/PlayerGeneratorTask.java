package by.it.marchenko.jd02_07;

import by.it.marchenko.jd02_07.util.FilePathFounder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerGeneratorTask extends Thread {
    public static final int MIN_AGE = 20;
    public static final int MAX_AGE = 40;
    public static final String PLAYERS_FILE = "players.txt";
    private static int id = 0;
    public static final int DEFAULT_COLLECTION_SIZE = 10;

    private String streamName = "";
    private final Set<Player> players = new HashSet<>();

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    private void generatePlayers() {
        for (int i = 0; i < DEFAULT_COLLECTION_SIZE; i++) {
            Player player = generatePlayer();
            players.add(player);
        }
    }

    private Player generatePlayer() {
        String name = streamName + "Name" + ++id;
        Integer age = ThreadLocalRandom.current().nextInt(MIN_AGE, MAX_AGE);
        boolean status = Math.random() > 0.5;
        return new Player(name, age, status);
    }

    private String savePlayersToFile() {
        String playersFile = FilePathFounder.getFilePath(PLAYERS_FILE);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(playersFile))) {
            for (Player player : players) {
                printWriter.println(player);
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return new File(playersFile).getName();
    }

    public String taskStream(String streamName) {
        setStreamName(streamName);
        generatePlayers();
        return savePlayersToFile();
    }

    /*@Override
    public void run() {
        taskStream("myStream");
    }*/
}