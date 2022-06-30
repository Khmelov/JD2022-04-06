package by.it.edeborg.jd02_03.organization;

public class Student extends Customer {
    public static final int MIN_COUNT_GOODS = 0;
    public static final int MAX_COUNT_GOODS = 2;
    private final String name;

    public Student(long number) {
        super(number);
        name = "Student №" + number;
    }

    @Override
    public int getMinCountGoods() {
        return MIN_COUNT_GOODS;
    }

    @Override
    public int getMaxCountGoods() {
        return MAX_COUNT_GOODS;
    }

    public String toString() {
        return name;
    }
}