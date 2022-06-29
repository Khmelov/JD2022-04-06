package by.it.marchenko.jd02_07.entity;

import by.it.marchenko.jd02_07.constant.MessageConstant;

import java.util.Comparator;

public class Player implements MessageConstant, Comparable<Player> {
    private final String name;
    private final Integer age;
    private final boolean isActive;

    public Player(String name, Integer age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(PLAYER_STRING_FORMAT, name, age, isActive);
    }

    @Override
    public int compareTo(Player o) {
        int ageComparing = this.age.compareTo(o.getAge());
        return ageComparing == 0 ?
                this.name.compareTo(o.getName()) :
                ageComparing;
    }
}
