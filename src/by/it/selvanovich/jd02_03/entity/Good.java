package by.it.selvanovich.jd02_03.entity;

import by.it.selvanovich.jd02_02.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class Good {

    private final String name;
    private final Integer price;
    private final HashMap<String, Integer> PriceListRepo = new HashMap<>();

    {
        PriceListRepo.put("Хлеб", RandomGenerator.getInteger(1, 3));
        PriceListRepo.put("Молоко", RandomGenerator.getInteger(1, 5));
        PriceListRepo.put("Колбаса", RandomGenerator.getInteger(4, 10));
        PriceListRepo.put("Вода", RandomGenerator.getInteger(1, 4));
        PriceListRepo.put("Творог", RandomGenerator.getInteger(1, 4));
    }

    public Good(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Good() {
        int goodId = RandomGenerator.get(4);
        ArrayList<String> goodNames = new ArrayList<>(PriceListRepo.keySet());
        name = goodNames.get(goodId);
        price = PriceListRepo.get(name);
    }

    public Integer showPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good: " + name + " price: " + price + "BYN";
    }
}
