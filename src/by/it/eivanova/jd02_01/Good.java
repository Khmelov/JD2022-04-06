package by.it.eivanova.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

public class Good {

    private final String name;
    private final Integer price;
    private final HashMap<String, Integer> PriceListRepo = new HashMap<>();
    {
        PriceListRepo.put("Cыр", RandomGenerator.getInteger(1,3));
        PriceListRepo.put("Вино", RandomGenerator.getInteger(1,5));
        PriceListRepo.put("Хамон", RandomGenerator.getInteger(4,10));
        PriceListRepo.put("Креветки", RandomGenerator.getInteger(1,4));
        PriceListRepo.put("Лосось", RandomGenerator.getInteger(1,4));
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

    @Override
    public String toString() {
        return "Good: " + name + " price: " + price + "EUR";
    }
}
