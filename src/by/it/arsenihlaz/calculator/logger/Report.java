package by.it.arsenihlaz.calculator.logger;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.*;

public class Report {
    private String header = "";
    private String workingTime = "";
    private String events = "";

    public void setHeader(String header) {
        this.header = header;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public void setEvents(String events) {
        this.events = events;
    }


    @Override
    public String toString() {
        return header + "\n"
                + workingTime + "\n"
                + events + "\n";
    }

    public void writeReport(Report report) {
        String path = Util.getPath(LoggerEnum.class, "simpleReport.txt");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(report);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
