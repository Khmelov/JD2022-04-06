package by.it.kameisha.jd02_07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlayerGeneratorTask extends Thread {
    private final List<Player> playerList = new ArrayList<>();
    private final String path;

    public PlayerGeneratorTask(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Player player = PlayerGenerator.generatePlayer();
            playerList.add(player);
        }
        writeInTxtFile();
    }
    public void writeInTxtFile() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path))) {
            printWriter.print(playerList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
