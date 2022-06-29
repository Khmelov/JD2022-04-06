package by.it.machuga.calc.reporter;

import java.time.ZonedDateTime;
import java.util.Objects;

public class ReportLine {
    private String type;
    private ZonedDateTime time;
    private String message;
    private Exception exception;

    public ReportLine(String type, String message, Exception exception) {
        this.type = type;
        this.message = message;
        this.exception = exception;
        this.time = ZonedDateTime.now();
    }

    public ReportLine(String type, String message) {
        this.type = type;
        this.message = message;
        this.time = ZonedDateTime.now();
    }

    public String getType() {
        return type;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return type + " " + time + " " + message + " " + (Objects.nonNull(exception) ? exception : "");
    }
}
