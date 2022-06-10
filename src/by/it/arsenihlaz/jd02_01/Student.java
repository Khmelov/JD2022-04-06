package by.it.arsenihlaz.jd02_01;

public class Student extends Customer {
    public final String name;

    public Student(long number) {
        super(number);
        this.name = "Student №" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
