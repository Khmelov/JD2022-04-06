package by.it.ragach.jd02_03.entity;

import by.it.ragach.jd02_03.util.RandomGenerator;

public class Student extends Customer {

   public final String name;


    public Student(long number) {
        super(number);
        this.name = "Customer (Student) №" + number;

    }

    @Override
    public int numberOfGoods() {
        return RandomGenerator.get(0,2);
    }

    @Override
    public String toString() {
        return name;
    }
}
