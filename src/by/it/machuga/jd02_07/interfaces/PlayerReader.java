package by.it.machuga.jd02_07.interfaces;

import by.it.machuga.jd02_07.entity.Player;

import java.util.List;

public interface PlayerReader {

    List<Player> readPlayersFromFile(String fileName);

    List<Player> filterPlayers(List<Player> players, boolean isActive, int minAge, int maxAge);
}
