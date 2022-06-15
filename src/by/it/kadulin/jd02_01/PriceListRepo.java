package by.it.kadulin.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListRepo {
    private static final List<String> namesGoods = new ArrayList<>();
    private static final Map<String, Double> goodsPriceList = new HashMap<>();
    private long countGoods = 0;

    public PriceListRepo() {
        fillGoods();
    }

    public static List<String> getNamesOfPriceList() {
        return namesGoods;
    }

    public static double getPrice(String name) {
        return goodsPriceList.get(name);
    }

    private void fillGoods() {
        goodsPriceList.put("Ryzen 9 5900x", 500.);
        namesGoods.add("Ryzen 9 5900x");
        goodsPriceList.put("Ryzen 5 5600x", 300.);
        namesGoods.add("Ryzen 5 5600x");
        goodsPriceList.put("Ryzen 5 5600", 290.);
        namesGoods.add("Ryzen 5 5600");
        goodsPriceList.put("Ryzen 5 5500", 250.);
        namesGoods.add("Ryzen 5 5500");
        goodsPriceList.put("Ryzen 9 5950x", 800.);
        namesGoods.add("Ryzen 9 5950x");
        goodsPriceList.put("Crucial Ballistix 3600MHz CL16", 110.);
        namesGoods.add("Crucial Ballistix 3600MHz CL16");
        goodsPriceList.put("MSI MPG X570S EDGE MAX WIFI", 250.);
        namesGoods.add("MSI MPG X570S EDGE MAX WIFI");
        goodsPriceList.put("Phanteks AMP 650W 80 Plus Gold", 100.);
        namesGoods.add("Phanteks AMP 650W 80 Plus Gold");
        goodsPriceList.put("Sapphire Radeon RX 6650 XT NITRO GAMING OC 8GB GDDR6", 550.);
        namesGoods.add("Sapphire Radeon RX 6650 XT NITRO GAMING OC 8GB GDDR6");
        goodsPriceList.put("Sapphire Radeon RX 6750 XT PULSE GAMING OC 12GB GDDR6", 850.);
        namesGoods.add("Sapphire Radeon RX 6750 XT PULSE GAMING OC 12GB GDDR6");
        goodsPriceList.put("MSI Optix G251F", 250.);
        namesGoods.add("MSI Optix G251F");
    }
}
