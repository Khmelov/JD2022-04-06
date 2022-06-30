package by.it.kadulin.jd02_07.service;

import by.it.kadulin.jd02_07.entity.Player;
import by.it.kadulin.jd02_07.util.PathForTxtFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements Callable<String> {
    private final List<Player> players = Collections.synchronizedList(new ArrayList<>());
    private String fileName = "";

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PathForTxtFiles.getPath(PlayerGeneratorTask.class, fileName + ".txt")))) {
            for (Player player : players) {
                writer.write(player.toString() + "\n");
            }


        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    private void addPlayers() {
        for (int i = 0; i < 10; i++) {
            players.add(new Player("player_" + i));
        }
    }

    @Override
    public String call() throws Exception {
        addPlayers();
        writeToFile();
//        System.out.println(players.size());
        return PathForTxtFiles.getPath(PlayerGeneratorTask.class, fileName + ".txt");
    }
}
