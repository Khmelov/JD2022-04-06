package by.it.arsenihlaz.jd02_07;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlayerReaderTask extends Thread {

    @Override
    public void run() {

    }

    public void readFile(String filename) {
        List<Player> activePlayerList = new ArrayList<>();
        String path = Util.getPath(PlayerGeneratorTask.class, filename);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            Scanner scanner = new Scanner(bufferedReader);
            while (scanner.hasNextLine()) {



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
