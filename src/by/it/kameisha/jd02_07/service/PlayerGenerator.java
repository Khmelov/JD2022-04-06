package by.it.kameisha.jd02_07.service;

import by.it.kameisha.jd02_07.entity.Player;
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
