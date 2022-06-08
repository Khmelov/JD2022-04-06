package by.it.kameisha.jd02_02;

public class Good {
    private final String name;

    public Good(String name) {
        this.name = name;
    }

    public Good(Good good) {
        this.name = good.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
