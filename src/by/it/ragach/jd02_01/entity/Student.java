package by.it.ragach.jd02_01.entity;

import by.it.ragach.jd02_01.util.RandomGenerator;

public class Student extends Customer {

   public final String name;


    public Student(int number) {
        super(number);
        this.name = "Customer (Student) №" + number;

    }

    @Override
    public int quantityOfGoods() {
        return RandomGenerator.get(0,2);
    }

    @Override
    public String toString() {
        return name;
    }
}
