package by.it.marchenko.jd02_07.service;

import by.it.marchenko.jd02_07.constant.MessageConstant;
import by.it.marchenko.jd02_07.entity.Player;
import by.it.marchenko.jd02_07.util.FilePathFounder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

public class PlayerReaderTask implements Callable<Set<Player>>, MessageConstant {
    private final Set<Player> players = new HashSet<>();
    private final Set<Player> selectedPlayers = new HashSet<>();

    private final String fileName;

    public PlayerReaderTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Set<Player> call() throws Exception {
        Set<Player> players = readFromFile(fileName);
        return selectPlayers(players);
    }

    public Set<Player> readFromFile(String fileName) {
        String file = FilePathFounder.getFilePath(fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = in.readLine();
                if (!Objects.isNull(line)) {
                    Player player = valueOf(line);
                    players.add(player);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_FOUND, e);
        }
        return players;
    }

    public static Player valueOf(String line) {
        Player player = null;
        String[] elements = line.split(SPACES);
        try {
            String name = elements[0];
            int age = Integer.parseInt(elements[1]);
            boolean isActive = Boolean.parseBoolean(elements[2]);
            player = new Player(name, age, isActive);
        } catch (Exception e) {
            System.out.println(INCORRECT_PLAYER_PARSING);
        }
        return player;
    }

    private Set<Player> selectPlayers(Set<Player> players) {
        for (Player player : players) {
            int age = player.getAge();
            if (player.isActive() && age >= MIN_ALLOWED_AGE && age <= MAX_ALLOWED_AGE) {
                selectedPlayers.add(player);
            }
        }
        return selectedPlayers;
    }
}
