package by.it.machuga.jd02_07.servise;

import by.it.machuga.jd02_07.ConsoleRunner;
import by.it.machuga.jd02_07.entity.Player;
import by.it.machuga.jd02_07.interfaces.Constants;
import by.it.machuga.jd02_07.interfaces.PlayerGenerator;
import by.it.machuga.jd02_07.util.PathFinder;
import by.it.machuga.jd02_07.util.RandomGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements PlayerGenerator, Callable<String> {
    private final int playersCount;

    public PlayerGeneratorTask(int playersCount) {
        this.playersCount = playersCount;
    }

    @Override
    public String call() {
        List<Player> players = generatePlayers(playersCount);
        String path = PathFinder.getPath(ConsoleRunner.class,
                RandomGenerator.getRandomText(Constants.FILE_NAME_SIZE) + Constants.FILE_EXTENSION);
        writePlayersToFile(players, path);
        return path;
    }

     public List<Player> generatePlayers(int playersCount) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playersCount; i++) {
            String name = RandomGenerator.getRandomText(Constants.PLAYER_NAME_SIZE);
            Integer age = RandomGenerator.getRandomInt(Constants.MIN_AGE, Constants.MAX_AGE);
            boolean isActive = RandomGenerator.getRandomBoolean();
            Player player = new Player(name, age, isActive);
            players.add(player);
        }
        return players;
    }

     public void writePlayersToFile(List<Player> players, String path) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            for (Player player : players) {
                printWriter.println(player.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
