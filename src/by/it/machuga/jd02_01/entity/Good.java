package by.it.machuga.jd02_01.entity;

public class Good {

    private final String name;

    public Good(String name) {
        this.name = "Good " + name;
    }

    @Override
    public String toString() {
        return name;
    }
}
