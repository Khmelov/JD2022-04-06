package by.it.arsenihlaz.jd02_07;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlayerGeneratorTask extends Thread {
    public static final int LIST_SIZE = 10;
    private final Player player;
    private int countPlayer;

    List<Player> playersList = new ArrayList<>(LIST_SIZE);

    public PlayerGeneratorTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        for (int i = 0; i < LIST_SIZE; i++) {
            playerGenerator();
            Player player = playerCreator();
            playersList.add(player);
        }
        writeToFile(playersList);
    }

    private Player playerCreator() {
        String name = player.getName();
        Integer age = player.getAge();
        boolean isActive = player.getIsActive();
        return new Player(name, age, isActive);
    }

    private void playerGenerator() {
        player.setName("Player №" + ++countPlayer);
        player.setAge(RandomGenerator.get(20, 40));
        player.setActive(RandomGenerator.getBoolean());
    }

    public String writeToFile(List<Player> player) {
        String filename = "players" + countPlayer + ".txt";
        String path = Util.getPath(PlayerGeneratorTask.class, filename);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(player);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return filename;
    }
}
