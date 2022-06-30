package by.it.kameisha.jd02_07.entity;

import java.io.Serial;
import java.io.Serializable;

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 5306432697310206205L;
    private final String name;
    private final Integer age;
    private final boolean isActive;

    public Player(String name, Integer age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
