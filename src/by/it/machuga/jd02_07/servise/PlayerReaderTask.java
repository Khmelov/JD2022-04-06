package by.it.machuga.jd02_07.servise;

import by.it.machuga.jd02_07.entity.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class PlayerReaderTask implements Callable<List<Player>> {
    private final String fileName;
    private final PlayerParser playerParser;

    public PlayerReaderTask(String fileName) {
        this.fileName = fileName;
        this.playerParser = new PlayerParser();
    }

    @Override
    public List<Player> call() {
        List<Player> players = readPlayersFromFile(fileName);
        List<Player> filteredPlayers = filterPlayers(players, true, 25, 30);
        return filteredPlayers;
    }

    private List<Player> filterPlayers(List<Player> players, boolean isActive, int minAge, int maxAge) {
        return players.stream().filter(player -> player.isActive() == true).filter(player -> player.getAge() >= minAge
                && player.getAge() <= maxAge).collect(Collectors.toList());
    }

    private List<Player> readPlayersFromFile(String fileName) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
