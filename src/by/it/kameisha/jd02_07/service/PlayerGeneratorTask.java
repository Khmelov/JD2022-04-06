package by.it.kameisha.jd02_07.service;

import by.it.kameisha.jd02_07.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements Callable<String> {
    private final List<Player> playerList = new ArrayList<>();
    private final String path;

    public PlayerGeneratorTask(String path) {
        this.path = path;
    }


    public void writeInTxtFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(playerList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String call() {
        for (int i = 0; i < 10; i++) {
            Player player = PlayerGenerator.generatePlayer();
            playerList.add(player);
        }
        writeInTxtFile();
        return path;
    }
}

