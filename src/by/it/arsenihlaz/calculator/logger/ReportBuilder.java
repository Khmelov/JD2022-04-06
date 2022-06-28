package by.it.arsenihlaz.calculator.logger;

import java.util.ArrayList;

public abstract class ReportBuilder {
    Report report;
    static ArrayList<String> calcOperationsList = new ArrayList<String>();
    static ArrayList<String> errorsList = new ArrayList<String>();


    public Report getReport() {
        return report;
    }

    void createNewReport() {
        report = new Report();
    }

    public abstract void buildHeader();

    public abstract void buildWorkingTime();

    public abstract void buildEvents();


    public static void setCalcOperation(String operation) {
        calcOperationsList.add(operation);
    }

    public ArrayList<String> getCalcOperation() {
        return calcOperationsList;
    }

    public static void setErrorsList(String error) {
        errorsList.add(error);
    }

    public ArrayList<String> getErrors() {
        return errorsList;
    }
}
