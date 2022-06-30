package by.it.kameisha.jd02_07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerReaderTask implements Callable<List<Player>> {
    public static String path;

    public PlayerReaderTask(String path) {
        this.path = path;
    }



    public List<Player> readFile(String path) {
        List<Player> playerList;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            playerList = (List<Player>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return selectPlayers(playerList);
    }

    private List<Player> selectPlayers(List<Player> playerList) {
        List<Player> newPlayerList = new ArrayList<>();
        for (Player player : playerList) {
            if (player.isActive() && player.getAge() >= 25 && player.getAge() <= 30) {
                newPlayerList.add(player);
            }
        }
        return newPlayerList;
    }

    @Override
    public List<Player> call() {
        return readFile(path);
    }
}
