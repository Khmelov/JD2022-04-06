package by.it.edeborg.jd02_03.repository;

import by.it.edeborg.jd02_03.organization.SomethingGood;
import by.it.kameisha.jd02_03.util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListRepository {
    public static final String PRICE_LIST_TXT = "PriceList.txt";

    private final Map<SomethingGood, Integer> priceList = new HashMap<>();

    private final List<SomethingGood> goodsList = new ArrayList<>();

    public Map<SomethingGood, Integer> getPriceList() {
        return priceList;
    }

    public List<SomethingGood> getGoodsList() {
        return goodsList;
    }

    public PriceListRepository() {
        String path = Util.getPath(PriceListRepository.class, PRICE_LIST_TXT);
        readPriceList(path);
    }

    public void readPriceList(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] goodsPrice = line.split("=", 2);
                SomethingGood good = new SomethingGood(goodsPrice[0].trim());
                goodsList.add(good);
                priceList.put(good, Integer.valueOf(goodsPrice[1].trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }
}