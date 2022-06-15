package by.it.marchenko.jd02_01.models;

import by.it.marchenko.jd02_01.repository.StockRepo;

public class Stock {
    private final StockRepo repo;
    private final String name;
    private final int capacity;

    public Stock(String name, int capacity, StockRepo repo) {

        this.name = name;
        this.capacity = capacity;
        this.repo = repo;
    }

    @Override
    public String toString() {

        return String.format("Goods amount in the stock %s: %d. Different positions: %d.%n",
                name, repo.getOccupiedPlace(), repo.getGoodIDAmount());

    }
}
