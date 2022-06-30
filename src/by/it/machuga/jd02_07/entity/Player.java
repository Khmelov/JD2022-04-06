package by.it.machuga.jd02_07.entity;

import java.util.Objects;

public class Player {
    private String name;
    private Integer age;
    private boolean isActive;

    public Player(String name, Integer age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return isActive == player.isActive && Objects.equals(name, player.name) && Objects.equals(age, player.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isActive);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }
}
