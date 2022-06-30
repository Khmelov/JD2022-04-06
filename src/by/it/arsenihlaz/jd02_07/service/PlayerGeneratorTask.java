package by.it.arsenihlaz.jd02_07.service;

import by.it.arsenihlaz.jd01_14.Util;
import by.it.arsenihlaz.jd02_07.util.RandomGenerator;
import by.it.arsenihlaz.jd02_07.entity.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlayerGeneratorTask extends Thread {
    public static final int LIST_SIZE = 10;
    private Player player;
    private int countPlayer;

    List<Player> playersList = new ArrayList<>(LIST_SIZE);

    public PlayerGeneratorTask() {
    }

    @Override
    public void run() {
        for (int i = 0; i < LIST_SIZE; i++) {
            Player player =  playerGenerator();
            playersList.add(player);
        }

        writeToFile(playersList);

    }


    private Player playerGenerator() {
        String name = "Player №" + ++countPlayer;
        Integer age = RandomGenerator.get(20, 40);
        boolean isActive = RandomGenerator.getBoolean();
        return new Player(name, age, isActive);
    }

    public String writeToFile(List<Player> player) {
        String filename = "players" + getName() + ".txt";
        String path = Util.getPath(PlayerGeneratorTask.class, filename);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(player);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return filename;
    }
}
