package by.it.avramchuk.jd02_02.entity;

import by.it.avramchuk.jd02_02.interfaces.CashierAction;

public class Cashier {

    private final String name;

    public Cashier(int number) {
        this.name = "Cashier №"+number;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
