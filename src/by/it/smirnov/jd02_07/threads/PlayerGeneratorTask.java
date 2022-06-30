package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.ConsoleRunner;
import by.it.smirnov.jd02_07.entity.Player;
import by.it.smirnov.jd02_07.utils.PathGetter;
import by.it.smirnov.jd02_07.utils.Randomizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static by.it.smirnov.jd02_07.constants.Constants.*;

public class PlayerGeneratorTask extends Thread {
    public volatile List<Player> players;

    public static volatile int fileNumber = 0;

    private static volatile int count = 0;

    @Override
    public synchronized void run() {
        players = new ArrayList<>();
        while (players.size()<=PLAYERS_LIST_SIZE) {
            String playerNumber = String.valueOf(++count);
            Integer playerAge = Randomizer.get(MIN_AGE,MAX_AGE);
            boolean playerIsActive = Randomizer.get(0, 1) == 1;
            players.add(new Player(PLAYER_NAME + playerNumber, playerAge, playerIsActive));
        }
        PlayerReaderTask playerReaderTask = new PlayerReaderTask(writeToFile(players));
        playerReaderTask.start();
    }

    public static synchronized String writeToFile(List<Player> list){
        fileNumber++;
        String path = PathGetter.getPath(ConsoleRunner.class, FILE_TXT+fileNumber);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(path))){
            for (Player player : list) {
                printWriter.println(player.name + " " + player.getAge() + " " + player.isActive);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
}
