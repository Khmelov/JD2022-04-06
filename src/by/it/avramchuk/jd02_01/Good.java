package by.it.avramchuk.jd02_01;

public class Good {

   private final String name;

    public Good(String name) {
        this.name = name;
    }
    public Good() {
        this.name = "unknown good";
    }


    @Override
    public String toString() {
        return name;
    }
}
