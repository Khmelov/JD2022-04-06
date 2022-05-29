package by.it.kameisha.jd02_01;

public class Good {
    private final String name;

    public Good(String name) {
        this.name = name;
    }

    public Good() {
        System.out.println(name = "unknown good");
        ;
    }

    @Override
    public String toString() {
        return name;
    }
}
