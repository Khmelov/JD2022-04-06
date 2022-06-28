package by.it.arsenihlaz.calculator.logger;

import java.util.ArrayList;

public abstract class ReportBuilder {
    Report report;
    static ArrayList<String> calcOperations = new ArrayList<String>();

    public Report getReport() {
        return report;
    }

    void createNewReport() {
        report = new Report();
    }

    public abstract void buildHeader();

    public abstract void buildWorkingTime();

    public abstract void buildOperationResult();

    public static void setCalcOperation(String operation) {
        calcOperations.add(operation);
    }

    public ArrayList<String> getCalcOperation() {
        return calcOperations;
    }
}
