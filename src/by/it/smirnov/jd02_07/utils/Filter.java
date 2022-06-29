package by.it.smirnov.jd02_07.utils;

import by.it.smirnov.jd02_07.entity.Player;

import java.util.Comparator;
import java.util.List;

public class Filter {
    private Filter() {
    }

    public static void printFiltered(List<Player> list){
        Object[] first5 = list.stream()
                .sorted(Comparator.comparing(Player::getAge))
                .limit(5)
                .toArray();
        for (Object o : first5) {
            Player player = (Player) o;
            System.out.println(player.name);
        }
    }
}
