package by.it.smirnov.calc.report;

import by.it.smirnov.calc.ConsoleRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static by.it.smirnov.calc.constants.Wordings.REPORT_TXT;
import static by.it.smirnov.calc.util.PathGetter.getPath;

public class Report {

    protected static String reportText;

    Report() {
    }

    public void writeToFile(){
        String path = getPath(ConsoleRunner.class, REPORT_TXT);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(reportText);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
