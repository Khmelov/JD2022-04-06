package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.utility.RandomGenerator;

import static by.it.marchenko.jd02_03.constants.GoodConstants.*;

public class Good {
    private final int goodID;
    private final String name;
    private final double price;
    private final String currency;
    private final String goodPrintFormat;

    public Good(int goodID, String name, double price, String currency) {
        this.goodID = goodID;
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
    public Good(int goodID, String name, double price) {
        this(goodID, name, price, DEFAULT_CURRENCY);
    }

    public Good(int goodID) {
        this(
                goodID,
                "Good" + goodID,
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

        return String.format("%s with price %.2f %s", name, price, currency);
    }

    @SuppressWarnings("unused")
    public String toFormatString() {
        String printName = MAX_NAME_PRINT_LENGTH < name.length() ?
                name.substring(0, MAX_NAME_PRINT_LENGTH).concat(SUFFIX) : name;
        return String.format(goodPrintFormat,
                goodID, printName, price, currency);
    }
}
