package by.it.avramchuk.calc.logger;

import by.it.avramchuk.calc.constants.Patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReportBuilder {
    Report report;

    Report getReport() {
        return report;
    }

    void createNewReport() {
        report = new Report();
    }

    public abstract void addTitle();

    public abstract void addBody();

    public abstract void addEnding();

    public String[] getText() {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(Patterns.REPORT_PATH))) {
            while (reader.ready()) {
                text.append(reader.readLine());
                text.append("!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString().split("!");
    }
}
