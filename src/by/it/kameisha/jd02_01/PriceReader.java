package by.it.kameisha.jd02_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PriceReader {
    private final Map<Good, Integer> priceList = new HashMap<>();

    public PriceReader() {
    }

    public void readPriceList(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while (reader.ready()){
                String line = reader.readLine();
                String[] goodsPrice = line.split("=",2);
                Good good = new Good(goodsPrice[0].trim());
                priceList.put(good, Integer.valueOf(goodsPrice[1].trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file",e);
        }
    }
}
