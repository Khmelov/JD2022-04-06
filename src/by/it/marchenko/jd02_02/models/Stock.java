package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.repository.StockRepo;

@SuppressWarnings("unused")
public class Stock {
    //TODO implement correct invokation and method operation
    private final StockRepo repo;
    private final String name;
    @SuppressWarnings("FieldCanBeLocal")
    private final int capacity;

    public Stock(String name, int capacity, StockRepo repo) {

        this.name = name;
        this.capacity = capacity;
        this.repo = repo;
    }

    @Override
    public String toString() {

        return String.format("Goods amount in the stock %s: %d. Different positions: %d.%n",
                name, repo.getOccupiedPlace(), repo.getStockSize());

    }
}
