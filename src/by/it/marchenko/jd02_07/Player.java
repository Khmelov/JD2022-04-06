package by.it.marchenko.jd02_07;

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

    public Integer getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %b", "Player", name, age, isActive);
    }
}
