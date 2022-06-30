package by.it.kadulin.jd02_07.entity;

import by.it.kadulin.jd02_07.util.RandomGenerator;

public class Player {
    private String name;

    private int age;
    boolean isActive;
    public Player(String name) {
        this.name = name;
        this.age = RandomGenerator.get(20, 40);
        this.isActive = true;
    }

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        isActive = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name=" + name +" age=" + age;
    }
}
