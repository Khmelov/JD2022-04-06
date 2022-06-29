package by.it.machuga.jd02_07.interfaces;

import by.it.machuga.jd02_07.entity.Player;

import java.util.List;

public interface PlayerGenerator {

    List<Player> generatePlayers(int playersCount);

    void writePlayersToFile(List<Player> players, String path);
}
