package by.it.smirnov.jd02_07.threads;

import by.it.smirnov.jd02_07.entity.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.it.smirnov.jd02_07.constants.Constants.CHOSEN_MAX_AGE;
import static by.it.smirnov.jd02_07.constants.Constants.CHOSEN_MIN_AGE;

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
            for (Player player : list) {
                if (player.isActive && player.getAge() >= CHOSEN_MIN_AGE && player.getAge() <= CHOSEN_MAX_AGE) {
                    playersChosen.add(player);
                }
            }
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

