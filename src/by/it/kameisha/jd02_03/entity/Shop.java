package by.it.kameisha.jd02_03.entity;

import by.it.kameisha.jd02_03.repository.PriceListRepository;

public class Shop {
    private final String name;
    private final Queue queue;
    private final Manager manager;
    private final PriceListRepository repository;

    public String getName() {
        return name;
    }

    public Queue getQueue() {
        return queue;
    }

    public Shop(String name, Queue queue, Manager manager, PriceListRepository repository) {
        this.name = name;
        this.queue = queue;
        this.manager = manager;
        this.repository = repository;
    }

    public Manager getManager() {
        return manager;
    }

    public PriceListRepository getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return "Shop " + name;
    }
}
