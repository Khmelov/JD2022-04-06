package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.entity.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerReaderTask extends Thread {

    public static List<Player> playersChosen;

    static {
        playersChosen = new ArrayList<>();
    }

    private String fileName;

    public PlayerReaderTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        synchronized (playersChosen) {
            List<Player> list = readFile(fileName);
            playersChosen = list.stream()
                    .filter(player -> player.isActive)
                    .filter(player -> player.getAge() >= 25 && player.getAge() <= 30)
                    .collect(Collectors.toList());
            playersChosen.addAll(list);

        }
    }

    private List<Player> readFile(String fileName){
        List<Player> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String[] personData = reader.readLine().split(" ");
                boolean isActive = personData[2].equals("true");
                list.add(new Player(personData[0], Integer.parseInt(personData[1]), isActive));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

