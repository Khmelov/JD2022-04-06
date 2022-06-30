package by.it.arsenihlaz.jd02_07;

public class Player {
    String name;
    Integer age;
    boolean isActive;

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

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return name + "\n"
                + age + "\n"
                + isActive + "\n";
    }
}
