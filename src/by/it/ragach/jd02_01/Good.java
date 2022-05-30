package by.it.ragach.jd02_01;

public class Good {

    final private String name;

    public Good(String name) {
        this.name = name;
    }

    public Good(){
        name = "unknown good";
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                '}';
    }
}
