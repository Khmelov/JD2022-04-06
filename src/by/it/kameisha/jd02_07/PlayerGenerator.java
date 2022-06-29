package by.it.kameisha.jd02_07;

import by.it.kameisha.jd02_07.util.RandomGenerator;

public class PlayerGenerator {
    private PlayerGenerator() {
    }

    public static Player generatePlayer() {
        return new Player(
                RandomGenerator.getRandomName(),
                RandomGenerator.getRandomAge(20, 40),
                RandomGenerator.getRandomActive()
        );
    }
}
