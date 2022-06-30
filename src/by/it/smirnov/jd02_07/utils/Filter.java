package by.it.smirnov.jd02_07.utils;

import by.it.smirnov.jd02_07.entity.Player;

import java.util.Comparator;
import java.util.List;

import static by.it.smirnov.jd02_07.constants.Constants.FILTERED_NUMBER;

public class Filter {
    private Filter() {
    }

    public static void printFiltered(List<Player> list){
        Object[] filtered = list.stream()
                .sorted(Comparator.comparing(Player::getAge))
                .limit(FILTERED_NUMBER)
                .toArray();
        for (Object o : filtered) {
            Player player = (Player) o;
            System.out.println(player.name);
        }
    }
}
