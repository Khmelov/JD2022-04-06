package by.it.edeborg.jd02_02.organization;

public class SomethingGood {

    private final String name;

    public SomethingGood(String name) {
        this.name = name;
    }

    public SomethingGood() {
        name = "something good";
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                '}';
    }
}
