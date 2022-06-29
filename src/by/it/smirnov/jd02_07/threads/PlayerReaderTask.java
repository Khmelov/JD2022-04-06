package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerReaderTask extends Thread {

    private List<Player> players;
    public static final List<Player> playersChosen;

    static {
        playersChosen = new ArrayList<>();
    }

    public PlayerReaderTask(List<Player> players) {
        this.players = players;
    }

    @Override
    public void run() {
        synchronized (playersChosen) {
            for (Player player : players) {
                if (player.isActive && player.getAge() >= 25 && player.getAge() <= 30) {
                    playersChosen.add(player);
                }
            }
        }
    }
}
