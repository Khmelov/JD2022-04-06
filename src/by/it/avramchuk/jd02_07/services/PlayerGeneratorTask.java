package by.it.avramchuk.jd02_07.services;

import by.it.avramchuk.jd02_07.Runner;
import by.it.avramchuk.jd02_07.entity.Player;
import by.it.avramchuk.jd02_07.util.PathFinder;
import by.it.avramchuk.jd02_07.util.RandomGenerator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements Callable <String> {
    @Override
    public String call() {
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Integer age = RandomGenerator.get(20, 40);
            String name = "Player"+i;
            boolean active = RandomGenerator.get(1, 10) <= 5;
            Player player = new Player(name,age, active);
            players.add(player);
        }
        String path = PathFinder.getPath(Runner.class, "listPlayers.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
            out.writeObject(players);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
