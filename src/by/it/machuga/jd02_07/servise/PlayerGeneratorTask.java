package by.it.machuga.jd02_07.servise;

import by.it.machuga.jd02_07.ConsoleRunner;
import by.it.machuga.jd02_07.entity.Player;
import by.it.machuga.jd02_07.util.PathFinder;
import by.it.machuga.jd02_07.util.RandomGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements Callable<String> {
    @Override
    public String call() {
        List<Player>players=generatePlayers(10);
        String path= PathFinder.getPath(ConsoleRunner.class,RandomGenerator.getRandomText(5)+".txt");
        writePlayersToFile(players,path);
        return path;
    }

    private void writePlayersToFile(List<Player> players, String path) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path,true))){
            for (Player player : players) {
                printWriter.println(player.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Player> generatePlayers(int playersCount) {
        List<Player> players=new ArrayList<>();
        for (int i = 0; i < playersCount; i++) {
            String name= RandomGenerator.getRandomText(5);
            Integer age=RandomGenerator.getRandomInt(20,40);
            boolean isActive=RandomGenerator.getRandomBoolean();
            Player player=new Player(name,age,isActive);
            players.add(player);
        }
        return players;
    }
}
