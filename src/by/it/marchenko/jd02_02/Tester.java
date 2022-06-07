package by.it.marchenko.jd02_02;

import static by.it.marchenko.jd02_02.constants.GoodConstants.*;
import static by.it.marchenko.jd02_02.models.ShoppingCart.*;

public class Tester {
    public static void main(String[] args) {
        //Cashier cashier = new Cashier();
        //Cashier cashier2 = new Cashier("Tatyana");
        //Cashier cashier3 = new Cashier();

        //System.out.println(cashier);
        //System.out.println(cashier2);
        //System.out.println(cashier3);
        int qweri = BILL_PREFIX_TEXT.length() / 2;
        String billPrefixFormat = String.format("%%%ds%n", (LINE_LENGTH + BILL_PREFIX_TEXT.length()) / 2);
        //System.out.print(billPrefixFormat);
        System.out.printf(billPrefixFormat, BILL_PREFIX_TEXT);
        System.out.println("-".repeat(LINE_LENGTH));
        String BILL_SUMMARY_FORMAT = "%%s%%%d.%df %%%ds";
        String BILL_SUMMARY =
                String.format(BILL_SUMMARY_FORMAT,
                        MULTI_LINE_PRICE_TOTAL_PLACE - BILL_SUMMARY_TEXT.length(), PRICE_FLOAT_LENGTH, CURRENCY_LENGTH);
        System.out.println(BILL_SUMMARY);


    }


}
