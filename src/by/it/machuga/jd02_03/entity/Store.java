package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.repository.PriceListRepo;
import by.it.machuga.jd02_03.util.Constants;

public class Store {

    private final String name;
    private final PriceListRepo priceListRepo;
    private final Queue queue;
    private final Manager manager;

    public Store(String name, PriceListRepo priceListRepo, Queue queue, Manager manager) {
        this.name = name;
        this.priceListRepo = priceListRepo;
        this.queue = queue;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public PriceListRepo getPriceListRepo() {
        return priceListRepo;
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return Constants.STORE + name;
    }
}
