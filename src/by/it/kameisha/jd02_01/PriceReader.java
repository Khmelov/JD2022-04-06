package by.it.kameisha.jd02_01;

import by.it.kameisha.jd01_14.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PriceReader {
    private final Map<String, Integer> priceList = new HashMap<>();

    public PriceReader() {
    }

    public void readPriceList(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while (reader.ready()){
                String line = reader.readLine();
                String[] goodsPrice = line.split("=",2);
                priceList.put(goodsPrice[0].trim(), Integer.valueOf(goodsPrice[1].trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file",e);
        }
    }
}
