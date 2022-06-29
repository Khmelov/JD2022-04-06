package by.it.kadulin.jd02_07;

import by.it.kadulin.jd01_14.TaskA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PlayerReaderTask extends Thread {

    Thread thread;

    ArrayList<Player> playersFromFiles = new ArrayList<>();

    @Override
    public void run() {

        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = PlayerReaderTask.class.getName()
                .replace(PlayerReaderTask.class.getSimpleName(), "")
                .replace(".", File.separator);
        System.out.println(thread.getName());
        try (BufferedReader reader = new BufferedReader(new FileReader(root + relationPath + thread.getName() + ".txt"))) {
            String line = reader.readLine();
            String[] parameters = line.split(" ");
            String[] values;
            int age = Integer.parseInt(parameters[1].split("=")[1]);
            String name = parameters[0].split("=")[1];
            playersFromFiles.add(new Player(name, age));
            System.out.println(playersFromFiles.stream().filter(player -> player.getAge() >= 25 && player.getAge() <= 30));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
