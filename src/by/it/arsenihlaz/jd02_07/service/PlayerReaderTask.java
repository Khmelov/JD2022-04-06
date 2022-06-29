package by.it.arsenihlaz.jd02_07.service;

import by.it.arsenihlaz.jd01_14.Util;
import by.it.arsenihlaz.jd02_07.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class PlayerReaderTask extends Thread {

    @Override
    public void run() {
        readFile("players" + getName() + ".txt");

    }

    public void readFile(String filename) {
        List<Player> activePlayerList = new ArrayList<>();
        String path = Util.getPath(PlayerGeneratorTask.class, filename);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
//            Scanner scanner = new Scanner(bufferedReader);
//            Pattern pattern = Pattern.compile("[2][5-9]");
//            while (scanner.hasNextLine()) {
//                String ageFilter = scanner.findInLine(pattern);
//                if (scanner.nextLine().contains("true") && scanner.nextLine().contains(ageFilter) ) {
//                    System.out.println(scanner.nextLine());
//                }
//            }
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
               if (line.contains("true")){
//
               }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
