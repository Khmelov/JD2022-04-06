package by.it.machuga.jd02_01.entity;

import by.it.machuga.jd02_01.repository.PriceListRepo;
import by.it.machuga.jd02_01.util.Constants;

public class Store {

    private final String name;
    private final PriceListRepo priceListRepo;
    private int customerQuantity;

    public Store(String name, PriceListRepo priceListRepo) {
        this.name = name;
        this.priceListRepo = priceListRepo;
        this.customerQuantity = 0;
    }

    public String getName() {
        return name;
    }

    public PriceListRepo getPriceListRepo() {
        return priceListRepo;
    }

    public int getCustomerQuantity() {
        return customerQuantity;
    }

    public void setCustomerQuantity(int customerQuantity) {
        this.customerQuantity = customerQuantity;
    }

    @Override
    public String toString() {
        return Constants.STORE + name;
    }
}
