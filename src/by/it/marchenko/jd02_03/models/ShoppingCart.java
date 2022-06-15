package by.it.marchenko.jd02_03.models;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static by.it.marchenko.jd02_03.constants.GoodConstants.*;

public class ShoppingCart {

    public static final String BILL_GOOD_DELIMITER = "\n";
    public static final String BILL_PREFIX_TEXT = "R E C E I P T";
    public static final String BILL_PREFIX_FORMAT =
            String.format("%%%ds%n", (LINE_LENGTH + BILL_PREFIX_TEXT.length()) / 2);
    public static final String BILL_PREFIX =
            String.format(BILL_PREFIX_FORMAT, BILL_PREFIX_TEXT);
    public static final String SUMMARY_SEPARATOR = "-";

    public static final String BILL_SUMMARY_TEXT = "Total:";
    public static final String BILL_SUMMARY_FORMAT = String.format("%%s %%%d.%df %%%ds",
            MULTI_LINE_PRICE_TOTAL_PLACE - BILL_SUMMARY_TEXT.length(),
            PRICE_FLOAT_LENGTH, CURRENCY_LENGTH);

    private final List<Good> shoppingCartList;


    public ShoppingCart(int capacity) {
        shoppingCartList = new ArrayList<>(capacity);
    }

    public int getSize() {
        return shoppingCartList.size();
    }

    @SuppressWarnings("unused")
    public List<Good> getShoppingCartList() {
        return new ArrayList<>(shoppingCartList);
    }

    public double calculateCheckAmount() {
        double checkAmount = 0;
        for (Good good : shoppingCartList) {
            checkAmount += good.getPrice();
        }
        return checkAmount;
    }

    public String getBill() {
        String billSuffix = BILL_GOOD_DELIMITER +
                SUMMARY_SEPARATOR.repeat(LINE_LENGTH) + BILL_GOOD_DELIMITER +
                String.format(BILL_SUMMARY_FORMAT, BILL_SUMMARY_TEXT,
                        calculateCheckAmount(), DEFAULT_CURRENCY);
        StringJoiner bill = new StringJoiner(BILL_GOOD_DELIMITER, BILL_PREFIX, billSuffix);
        for (Good good : shoppingCartList) {
            bill.add(good.toFormatString());
        }
        return bill.toString();
    }

    public void addGoodToCart(Good good) {
        shoppingCartList.add(good);
    }

    @Override
    public String toString() {
        return shoppingCartList.toString();
    }
}
