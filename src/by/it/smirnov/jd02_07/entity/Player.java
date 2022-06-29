package by.it.smirnov.jd02_07.entity;

public class Player {

    public String name;

    Integer age;

    public Integer getAge() {
        return age;
    }

    public boolean isActive;

    public Player(String name, Integer age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }
}
