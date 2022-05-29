package by.it.arsenihlaz.jd02_01;

public class Good {

    private final String name;

    public Good(String name) {
        this.name = name;
    }

    public Good() {
        name = "unknown good";
    }

//    public Good(long id, String name, double price) {
//        this(id,name,price);
//    }

    @Override
    public String toString() {
        return name;
    }
}
