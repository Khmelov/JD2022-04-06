package by.it.marchenko.jd02_01;

public class ConstantRepository {
    // shop working time
    public static final int ONE_MINUTE = 60;
    public static final int WORK_TIME = 2 * ONE_MINUTE;

    // customer limits for A
    public static final boolean SIMPLY_CUSTOMER_LIMITATION = true;
    public static final int MAX_CUSTOMERS_COUNT_PER_SECOND = 2;
    // customer limits for C
    public static final boolean COMPLEX_CUSTOMER_LIMITATION = false;

    // operation time (in ms)
    public static final int MIN_CHOOSE_GOOD_TIME = 500;
    public static final int MAX_CHOOSE_GOOD_TIME = 2000;
}
