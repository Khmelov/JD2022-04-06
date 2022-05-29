package by.it.marchenko.jd02_01.constants;

public class GoodConstants {
    // price*100
    public static final int MIN_GOOD_PRICE = 1;
    public static final int MAX_GOOD_PRICE = 1_000_000;

    // good formatted output
    public static final String DEFAULT_CURRENCY = "$";
    public static final String ID_HOLDER = "0";
    public static final int ID_LENGTH = 11;
    public static final int NAME_LENGTH = 15;
    public static final int PRICE_TOTAL_LENGTH = 20;
    public static final int PRICE_FLOAT_LENGTH = 2;
    public static final int CURRENCY_LENGTH = 3;
    public static final int MULTI_LINE_PRICE_TOTAL_PLACE =
            ID_LENGTH + NAME_LENGTH + PRICE_TOTAL_LENGTH + 7;
    public static final String SUFFIX = "...";
    public static final int MAX_NAME_PRINT_LENGTH =
            ID_LENGTH + NAME_LENGTH + PRICE_TOTAL_LENGTH + CURRENCY_LENGTH - SUFFIX.length() - 9;

    public static final String GOOD_PRINT_SHORT_FORMAT = "Good %%%s%dd: %%-%ds %%%d.%df %%%ds";
    public static final String GOOD_PRINT_LONG_FORMAT = "Good %%%s%dd: %%-%ds%n %%%d.%df %%%ds";

}
