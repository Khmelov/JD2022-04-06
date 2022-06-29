package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.entity.Player;
import by.it.smirnov.jd02_07.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

import static by.it.smirnov.jd02_07.constants.Constants.PLAYER_NAME;

public class PlayerGeneratorTask extends Thread {
    List<Player> players;


    @Override
    public void run() {
        players = new ArrayList<>();
        while (players.size()<=10) {
            String playerNumber = String.valueOf(Randomizer.get(1,100));
            Integer playerAge = Randomizer.get(20,40);
            boolean playerIsActive = Randomizer.get(0, 1) == 1;
            players.add(new Player(PLAYER_NAME + playerNumber, playerAge, playerIsActive));
            PlayerReaderTask playerReaderTask = new PlayerReaderTask(players);
            playerReaderTask.start();
        }
    }
}
