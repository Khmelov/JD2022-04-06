package by.it.machuga.jd02_07.util;

import by.it.machuga.jd02_07.entity.Player;

import java.util.List;

public class Printer {
    public static void printNames(List<Player> players) {
        players.forEach(player -> System.out.println(player.getName().toUpperCase()));
    }
}
