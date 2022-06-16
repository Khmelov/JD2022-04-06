package by.it.kameisha.jd02_03.entity;

public class Student extends Customer {
    private final String name;

    public Student(long number) {
        super(number);
        name = "Student №" + number;
    }

    @Override
    public int getMinCountGoods() {
        return 0;
    }

    @Override
    public int getMaxCountGoods() {
        return 2;
    }

    public String toString() {
        return name;
    }
}
