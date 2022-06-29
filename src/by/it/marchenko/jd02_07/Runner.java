package by.it.marchenko.jd02_07;

import by.it.marchenko.jd02_07.service.PlayerFounder;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        PlayerFounder playerFounder = new PlayerFounder();
        List<String> topYoungest = playerFounder.findTopPlayer();
        System.out.println(topYoungest);
    }
}
