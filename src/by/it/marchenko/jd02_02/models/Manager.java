package by.it.marchenko.jd02_02.models;

public class Manager {
    public static final String DEFAULT_MANAGER_NAME = "Manager";
    public static final int START_ID_INITIAL_VALUE = 1;
    public static final int DEFAULT_PLAN = 100;

    private static int startID = START_ID_INITIAL_VALUE;

    private final String name;
    private final int id;
    private final int plan;

    public Manager(String name, int plan) {
        this.id = startID++;
        this.name = name;
        this.plan = plan;
    }

    public Manager(String name) {
        this.id = startID++;
        this.name = name;
        this.plan = DEFAULT_PLAN;
    }

    public Manager(int plan) {
        this(DEFAULT_MANAGER_NAME + startID, plan);
    }

    public Manager() {
        this(DEFAULT_PLAN);
    }

    public int getId() {
        return id;
    }

    public int getPlan() {
        return plan;
    }

    @Override
    public String toString() {
        return "Manager " + name;
    }
}
