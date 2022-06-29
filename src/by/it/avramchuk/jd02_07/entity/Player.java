package by.it.avramchuk.jd02_07.entity;

public class Player {
    private String name;
    private Integer age;
    private boolean isActive;

    public Player(String name, Integer age, boolean isActive){
        this.age = age;
        this.name= name;
        this.isActive = isActive;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
