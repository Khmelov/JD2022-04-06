package by.it.kudelko.jd02_01;

public class Good {

    private final String name;

    public Good(String name) {
        this.name = name;
    }

    public Good() {
        name = "unknown good";
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                '}';
    }
}
