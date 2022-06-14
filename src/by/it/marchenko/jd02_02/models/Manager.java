package by.it.marchenko.jd02_02.models;

import static by.it.marchenko.jd02_02.constants.ManagerConstant.*;

public class Manager {
    private static int startID = START_ID_INITIAL_VALUE;

    private final String name;
    private final int plan;

    public Manager(String name, int plan) {
        this.name = name;
        this.plan = plan;
        startID++;
    }

    public Manager(String name) {
        this.name = name;
        this.plan = DEFAULT_PLAN;
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

    @Override
    public String toString() {
        return MANAGER + name;
    }
}
