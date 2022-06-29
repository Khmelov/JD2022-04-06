package by.it.marchenko.jd02_07;

import by.it.marchenko.jd02_07.util.FilePathFounder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PlayerReaderTask {
    public static final String FILE_NOT_FOUND = "File not found";
    private final Set<Player> activePlayers = new HashSet<>();
    public static final String SPACES = "\s+";
    public static final int MIN_ALLOWED_AGE = 25;
    public static final int MAX_ALLOWED_AGE = 30;

    public Set<Player> createFromFile(String fileName) {
        String file = FilePathFounder.getFilePath(fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = in.readLine();
                if (!Objects.isNull(line)) {
                    System.out.println(line);
                    String[] elements = line.split(SPACES);
                    String name = elements[1];
                    int age = Integer.parseInt(elements[2]);
                    boolean isActive = Boolean.parseBoolean(elements[3]);
                    if (age >= MIN_ALLOWED_AGE && age <= MAX_ALLOWED_AGE && isActive) {
                        Player player = new Player(name, age, isActive);
                        activePlayers.add(player);
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_FOUND, e);
        }
        return activePlayers;
    }
}
