package by.it.machuga.jd02_01.entity;

import by.it.machuga.jd02_01.repository.PriceListRepo;

public class Store {

    private final String name;
    private final PriceListRepo priceListRepo;

    public Store(String name, PriceListRepo priceListRepo) {
        this.name = name;
        this.priceListRepo = priceListRepo;
    }

    public String getName() {
        return name;
    }

    public PriceListRepo getPriceListRepo() {
        return priceListRepo;
    }

    @Override
    public String toString() {
        return "Store " + name;
    }
}
