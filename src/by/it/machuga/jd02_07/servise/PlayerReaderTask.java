package by.it.machuga.jd02_07.servise;

import by.it.machuga.jd02_07.entity.Player;
import by.it.machuga.jd02_07.interfaces.Constants;
import by.it.machuga.jd02_07.interfaces.PlayerReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class PlayerReaderTask implements PlayerReader, Callable<List<Player>> {
    private final String fileName;
    private final PlayerParser playerParser;

    public PlayerReaderTask(String fileName) {
        this.fileName = fileName;
        this.playerParser = new PlayerParser();
    }

    @Override
    public List<Player> call() {
        List<Player> players = readPlayersFromFile(fileName);
        return filterPlayers(players, Constants.IS_ACTIVE_FILTER, Constants.MIN_AGE_FILTER, Constants.MAX_AGE_FILTER);
    }

    public List<Player> readPlayersFromFile(String fileName) {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                String line = reader.readLine();
                if (!Objects.isNull(line)) {
                    Player player = playerParser.getPlayer(line);
                    players.add(player);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    public List<Player> filterPlayers(List<Player> players, boolean isActive, int minAge, int maxAge) {
        return players.stream().filter(player -> player.isActive() == isActive).filter(player -> player.getAge() >= minAge
                && player.getAge() <= maxAge).collect(Collectors.toList());
    }
}
