package by.it.avramchuk.jd02_07.services;

import by.it.avramchuk.jd02_07.Runner;
import by.it.avramchuk.jd02_07.entity.Player;
import by.it.avramchuk.jd02_07.util.PathFinder;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class PlayerReaderTask implements Callable <List<Player>> {

    @Override
    public List<Player> call() throws Exception {
        String path = PathFinder.getPath(Runner.class, "listPlayers.dat");
        List<Player> players;


       try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))){
           Object object = reader.readObject();
           List<Player> object1 = (List<Player>) object;
           players = new ArrayList<>(object1);
       }
        return null;
    }
}
