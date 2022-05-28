package by.it.marchenko.jd02_01;

import static by.it.marchenko.jd02_01.GoodConstants.*;

public class Good {

    private final int id;
    private final String name;
    private final double price;
    private final String currency;
    private final String goodPrintFormat;

    public Good(int id, String name, double price, String currency) {
        this.id = id;
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

    public Good(int id, String name, double price) {
        this(id, name, price, DEFAULT_CURRENCY);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String printName = MAX_NAME_PRINT_LENGTH < name.length() ?
                name.substring(0, MAX_NAME_PRINT_LENGTH).concat(SUFFIX) : name;
        return String.format(goodPrintFormat,
                id, printName, price, currency);
    }
}
