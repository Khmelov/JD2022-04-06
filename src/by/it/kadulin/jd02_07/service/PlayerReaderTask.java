package by.it.kadulin.jd02_07.service;

import by.it.kadulin.jd01_14.TaskA;
import by.it.kadulin.jd02_07.entity.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class PlayerReaderTask extends Thread {

    private String path = "";
    private final ArrayList<Player> playersFromFiles = new ArrayList<>();

    @Override
    public void run() {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] parameters = line.split(" ");
                int age = Integer.parseInt(parameters[1].split("=")[1]);
                String name = parameters[0].split("=")[1];
                playersFromFiles.add(new Player(name, age));
            }
            String fileName = Path.of(path).getFileName().toString();
            String name = fileName.split("\\.")[0];
            StringBuilder result = new StringBuilder();
            result.append("from Thread-").append(name).append("\n");
            playersFromFiles.stream().filter(player -> player.getAge() >= 25 && player.getAge() <= 30).sorted(Comparator.comparingInt(Player::getAge)).limit(5).forEach(x -> result.append(x.getName().toUpperCase(Locale.ROOT)).append("\n"));
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String path) {
        this.path = path;
    }
}
