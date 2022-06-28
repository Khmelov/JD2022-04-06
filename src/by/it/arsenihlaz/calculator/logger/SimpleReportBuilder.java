package by.it.arsenihlaz.calculator.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void buildOperationResult() {
        int i = 0;
        ArrayList<String> calcOperations = getCalcOperation();
        StringBuilder stringBuilder = new StringBuilder();
        for (String operation : calcOperations) {
            stringBuilder.append("Operation №" + ++i + ": " + operation);
            stringBuilder.append("\n");
        }
        report.setOperationResult(String.valueOf(stringBuilder));
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
