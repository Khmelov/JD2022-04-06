package by.it.marchenko.jd02_01.models;

import static by.it.marchenko.jd02_01.constants.CustomerConstant.*;

public class Student extends Customer {

    @Override
    public int getMinCartCapacity() {
        return STUDENT_MIN_CART_CAPACITY;
    }

    @Override
    public int getMaxCartCapacity() {
        return STUDENT_MAX_CART_CAPACITY;
    }

    @Override
    public String toString() {
        String name = super.getName();
        int id = super.getId();
        return String.format("%-10s #%-3d %7s ", STUDENT, id, name);
    }
}
