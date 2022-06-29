package by.it.arsenihlaz.calculator.logger;

import java.util.ArrayList;

public class DetailedReportBuilder extends ReportBuilder {

    public void buildHeader() {
        report.setHeader("Detailed report:");
    }

    public void buildWorkingTime() {
        String dataTimeStart = DataTimeWorking.getDataTimeStart();
        String dataTimeEnd = DataTimeWorking.getDataTimeEnd();
        report.setWorkingTime("application was launched in: " + dataTimeStart + "\n"
                + "application was completed in: " + dataTimeEnd);
    }

    public void buildEvents() {
        int countOperation = 0;
        int countErrors = 0;
        ArrayList<String> calcOperations = getCalcOperation();
        ArrayList<String> errorList = getErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (String operation : calcOperations) {
            stringBuilder.append("Operation №" + ++countOperation + ": " + operation);
            stringBuilder.append("\n");
        }
        for (String error : errorList) {
            stringBuilder.append("Error №" + ++countErrors + ": " + error);
            stringBuilder.append("\n");
        }
        report.setEvents(String.valueOf(stringBuilder));
    }


}
