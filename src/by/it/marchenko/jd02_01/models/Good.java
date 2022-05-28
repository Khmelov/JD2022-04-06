package by.it.marchenko.jd02_01.models;

import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.constants.GoodConstants.*;

public class Good {
    private static int startId = 1;
    private final int currentId;
    private final String name;
    private final double price;
    private final String currency;
    private final String goodPrintFormat;

    public Good(String name, double price, String currency) {
        currentId = startId++;
        this.name = name;
        this.price = price;
        this.currency = currency;
        if (NAME_LENGTH < name.length()) {
            this.goodPrintFormat = String.format(GOOD_PRINT_LONG_FORMAT,
                    ID_HOLDER, ID_LENGTH, NAME_LENGTH,
                    MULTI_LINE_PRICE_TOTAL_PLACE, PRICE_FLOAT_LENGTH,
                    CURRENCY_LENGTH);
        } else {
            this.goodPrintFormat = String.format(GOOD_PRINT_SHORT_FORMAT,
                    ID_HOLDER, ID_LENGTH, NAME_LENGTH,
                    PRICE_TOTAL_LENGTH, PRICE_FLOAT_LENGTH,
                    CURRENCY_LENGTH);
        }
    }

    @SuppressWarnings("unused")
    public Good(String name, double price) {
        this(name, price, DEFAULT_CURRENCY);
    }

    public Good() {
        this(
                "Good" + startId,
                RandomGenerator.getRandom(1, 10000) / 100.0,
                DEFAULT_CURRENCY);
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String printName = MAX_NAME_PRINT_LENGTH < name.length() ?
                name.substring(0, MAX_NAME_PRINT_LENGTH).concat(SUFFIX) : name;
        return String.format(goodPrintFormat,
                currentId, printName, price, currency);
    }
}
