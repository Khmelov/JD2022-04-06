package by.it.kadulin.jd02_07;

import by.it.kadulin.jd01_14.TaskB;
import by.it.kadulin.jd01_14.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerGeneratorTask extends Thread {
    private List<Player> players = Collections.synchronizedList(new ArrayList<Player>());


    @Override
    public void run() {
        addPlayers();
        writeToFile();
        System.out.println(players.size());
//        for (Player player : players) {
//            System.out.println(player);
//        }
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Util.getPath(PlayerGeneratorTask.class, getNameThread() + ".txt")))) {
            for (Player player : players) {
                writer.write(player.toString() + "\n");
            }


        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setNameThread(String nameThread) {
        Thread.currentThread().setName(nameThread);
    }

    public String getNameThread() {
        return Thread.currentThread().getName();
    }

    private void addPlayers() {
        for (int i = 0; i < 10; i++) {
            players.add(new Player("player_" + i));
        }
    }
}
