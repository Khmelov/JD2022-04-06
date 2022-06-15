package by.it.marchenko.jd02_02.models;

import static by.it.marchenko.jd02_02.constants.ManagerConstant.*;
import static by.it.marchenko.jd02_02.constants.StoreConstant.COMPLEX_CUSTOMER_LIMITATION;
import static by.it.marchenko.jd02_02.constants.StoreConstant.SIMPLY_CUSTOMER_LIMITATION;

public class Manager {
    private static int startID = START_ID_INITIAL_VALUE;

    private final String name;
    private final int plan;
    private final boolean customerLimitationMode;


    public Manager(String name, int plan) {
        this.name = name;
        this.plan = plan;
        this.customerLimitationMode = COMPLEX_CUSTOMER_LIMITATION;
        startID++;
    }

    public Manager(String name) {
        this.name = name;
        this.plan = DEFAULT_PLAN;
        this.customerLimitationMode = COMPLEX_CUSTOMER_LIMITATION;
        startID++;
    }

    public Manager(int plan) {
        this(DEFAULT_MANAGER_NAME + startID, plan);
    }

    public Manager() {
        this(DEFAULT_PLAN);
    }

    public int getPlan() {
        return plan;
    }

    public boolean getCustomerLimitationMode() {
        return customerLimitationMode;
    }

    @Override
    public String toString() {
        return MANAGER + name;
    }
}
