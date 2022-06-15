package by.it.avramchuk.jd02_01;

public class Student extends Customer{
    public Student(long number) {
        super(number);
    }

    @Override
    public String toString() {
        return super.name+" student";
    }

    @Override
    public int mayToBuy() {
        return RandomGenerator.get(2);
    }
}
