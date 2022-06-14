package by.it.ragach.jd02_01;

public class Student extends Customer {

   public final String name;


    public Student(int number) {
        super(number);
        this.name = "Customer №" + number + " is Student";

    }

    @Override
    public String toString() {
        return name;
    }
}
