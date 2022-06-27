package by.it.marchenko.calc.log.report;

import static by.it.marchenko.calc.constant.MessageConst.NEW_LINE;

public class ReportEvent {

    public static final int INDENT_LENGTH = 22;
    public static final String RESULT_LINE_INDENT = " ".repeat(INDENT_LENGTH);

    private enum EventType {
        ERROR, INFO
    }

    private String timeStamp;
    private String inputExpression;
    private String operationResult;
    private EventType type = EventType.INFO;

    public void setInputExpression(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public void setErrorEventType() {
        this.type = EventType.ERROR;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public String toString() {
        String firstLine = String.format("%-21s %s", timeStamp, inputExpression);
        String[] resultLines = operationResult.split(NEW_LINE);
        StringBuilder sb = new StringBuilder(NEW_LINE + RESULT_LINE_INDENT + resultLines[0]);
        if (resultLines.length > 1) {
            for (int i = 1; i < resultLines.length; i++) {
                sb.append(NEW_LINE).append(RESULT_LINE_INDENT)
                        .append(resultLines[i]);
            }
        }
        return firstLine + sb;
    }
}
