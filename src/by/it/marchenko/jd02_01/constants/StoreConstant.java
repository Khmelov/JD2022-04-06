package by.it.marchenko.jd02_01.constants;

import static by.it.marchenko.jd02_01.constants.ConstantRepository.*;

public class StoreConstant {
    public static final String STORE = "Store";
    public static final String OPENED_MESSAGE = " opened.";
    public static final String CLOSED_MESSAGE = " closed.";

    public static final int ONE_MINUTE = 60;
    public static final int HALF_A_MINUTE = ONE_MINUTE / 2;
    public static final int WORK_TIME = 2 * ONE_MINUTE;

    public static final int REAL_ONE_SECOND = 1000;

    public static final int MAX_CUSTOMERS_COUNT_PER_SECOND = 2;
    public static final boolean SIMPLY_CUSTOMER_LIMITATION = true;
    public static final boolean COMPLEX_CUSTOMER_LIMITATION = false;

    public static final int STARTED_CUSTOMER_AMOUNT = 10;
    public static final int MIN_MIDDLE_MINUTE_CUSTOMER_AMOUNT = 30;
    public static final int MAX_MIDDLE_MINUTE_CUSTOMER_AMOUNT = 40;


}
