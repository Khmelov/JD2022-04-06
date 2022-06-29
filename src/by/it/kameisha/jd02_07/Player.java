package by.it.kameisha.jd02_07;

public class Player {
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

    public Integer getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
