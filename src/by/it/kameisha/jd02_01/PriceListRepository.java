package by.it.kameisha.jd02_01;

import by.it.kameisha.jd01_14.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListRepository {
    public static final String PRICE_LIST_TXT = "PriceList.txt";

    private final Map<Good, Integer> priceList = new HashMap<>();

    private final List<Good> goodsList = new ArrayList<>();

    public Map<Good, Integer> getPriceList() {
        return priceList;
    }

    public List<Good> getGoodsList() {
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
                Good good = new Good(goodsPrice[0].trim());
                goodsList.add(good);
                priceList.put(good, Integer.valueOf(goodsPrice[1].trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }
}
