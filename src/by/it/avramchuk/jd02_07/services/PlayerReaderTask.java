package by.it.avramchuk.jd02_07.services;

import by.it.avramchuk.jd02_07.Runner;
import by.it.avramchuk.jd02_07.entity.Player;
import by.it.avramchuk.jd02_07.util.PathFinder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class PlayerReaderTask implements Callable<List<Player>> {

    @Override
    public List<Player> call() {
        String path = PathFinder.getPath(Runner.class, "listPlayers.dat");
        List<Player> players = new ArrayList<>();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {
            Object object = reader.readObject();
            ArrayList<Player> object1 = (ArrayList<Player>) object;
            players.addAll(object1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return filterList(players);

    }

    private List<Player> filterList(List<Player> players) {
        return players.stream().filter(Player::isActive)
                .filter(o -> o.getAge() >= 25)
                .filter(o -> o.getAge() <= 30)
                .collect(Collectors.toList());
    }
}
