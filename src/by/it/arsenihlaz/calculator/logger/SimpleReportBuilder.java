package by.it.arsenihlaz.calculator.logger;

import java.util.ArrayList;

public class SimpleReportBuilder extends ReportBuilder {

    public void buildHeader() {
        report.setHeader("Simple report:");
    }

    public void buildWorkingTime() {
        String dataTimeStart = DataTimeWorking.getDataTimeStart();
        String dataTimeEnd = DataTimeWorking.getDataTimeEnd();
        report.setWorkingTime("application was launched in: " + dataTimeStart + "\n"
                + "application was completed in: " + dataTimeEnd);
    }

    public void buildEvents() {
        int countOperation = 0;
        ArrayList<String> calcOperations = getCalcOperation();
        StringBuilder stringBuilder = new StringBuilder();
        for (String operation : calcOperations) {
            stringBuilder.append("Operation №" + ++countOperation + ": " + operation);
            stringBuilder.append("\n");
        }
        report.setEvents(String.valueOf(stringBuilder));
    }
}
