package by.it.marchenko.jd02_03.constants;

public class StoreConstant {
    public static final String STORE_NAME = "Green";
    public static final String MANAGER_NAME = "Ivan Drago";

    public static final String STORE = "Store";
    public static final String OPENED_MESSAGE = " is opened by ";
    public static final String CLOSED_MESSAGE = " is closed by ";

    public static final int ONE_MINUTE = 60;
    public static final int HALF_A_MINUTE = ONE_MINUTE / 2;
    public static final int WORK_TIME = 2 * ONE_MINUTE;

    public static final int REAL_ONE_SECOND = 1000;

    public static final int MAX_CUSTOMERS_COUNT_PER_SECOND = 2;
    public static final int MAX_CUSTOMER_COUNT = 100;

    public static final boolean SIMPLY_CUSTOMER_LIMITATION = true;
    public static final boolean COMPLEX_CUSTOMER_LIMITATION = false;

    public static final int STARTED_CUSTOMER_AMOUNT = 10;
    public static final int MIN_MIDDLE_MINUTE_CUSTOMER_AMOUNT = 30;
    public static final double MIN_COUNTER_TEMP =
            (double) ((MIN_MIDDLE_MINUTE_CUSTOMER_AMOUNT - STARTED_CUSTOMER_AMOUNT)) / HALF_A_MINUTE;
    public static final int MAX_MIDDLE_MINUTE_CUSTOMER_AMOUNT = 40;
    public static final double MAX_COUNTER_TEMP =
            (double) ((MAX_MIDDLE_MINUTE_CUSTOMER_AMOUNT - STARTED_CUSTOMER_AMOUNT)) / HALF_A_MINUTE;

    public static final int STORE_START_ID = 1;
    public static final int CUSTOMER_PER_CASHIER = 5;
    public static final int MAX_CASHIER_COUNT = 5;
    public static final int DEFAULT_CASHIER_COUNT = 2;

    public static final boolean SIMPLY_CASHIER_MODE = true;
    public static final int INIT_PROGRESS_DELAY_TIME = 20;
    public static final String STOCK_INIT_IN_PROGRESS = "Stock init in progress";
    public static final String STOCK_INIT_FINISHED = "\nStock init finished.";
    public static final String OPEN_STORE_FORMAT = "%s%s%s%n";
}
