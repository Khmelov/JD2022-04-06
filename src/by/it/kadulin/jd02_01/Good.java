package by.it.kadulin.jd02_01;

public class Good {
    private final String name;

    public Good(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                '}';
    }

    public Good() {
        name = "unknown good";
    }
}
