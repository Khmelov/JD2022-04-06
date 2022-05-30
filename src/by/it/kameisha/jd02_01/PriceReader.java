package by.it.kameisha.jd02_01;

import by.it.kameisha.jd01_14.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PriceReader {
    public static final String PRICE_LIST_TXT = "PriceList.txt";
    private final Map<String, Integer> priceList = new HashMap<>();
    String path = Util.getPath(PriceReader.class, PRICE_LIST_TXT);

    private void readPriceList(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while (reader.lines()!=null){
                String line = reader.readLine();
                String[] goodsPrice = line.split("=");
                priceList.put(goodsPrice[0].trim(), Integer.valueOf(goodsPrice[1].trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file",e);
        }
    }
}
