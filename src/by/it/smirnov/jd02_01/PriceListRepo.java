package by.it.smirnov.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListRepo {

    public static final Map<String, Double> priceList = new HashMap<>();

    static {
        priceList.put("Elixir strings Baritone 12-68", 12.0);
        priceList.put("Elixir strings Light 9-46", 9.6);
        priceList.put("Vic Firth drumsticks 2B", 14.0);
        priceList.put("Vic Firth drumsticks 2BN", 14.1);
        priceList.put("TAMA twin drum pedal Speed Cobra HP910LN", 1210.7);
        priceList.put("DW twin drum pedal 5000", 2500.0);
        priceList.put("Ultex pick 1,2mm", 0.6);
        priceList.put("Gibson LesPaul Classic, black", 2700.0);
        priceList.put("Gibson LesPaul Custom, sunburst", 4100.0);
        priceList.put("Gibson Flying V Standard, white", 1900.0);

    }

    public static String getRandomGoodName(){
        List<String> goodsPositions = new ArrayList<>(priceList.keySet());
        int randomGoodNumber = Randomizer.get(0, goodsPositions.size()-1);
        return goodsPositions.get(randomGoodNumber);
    }
}
