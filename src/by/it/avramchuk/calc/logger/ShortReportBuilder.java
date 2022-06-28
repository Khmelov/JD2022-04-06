package by.it.avramchuk.calc.logger;

import by.it.avramchuk.calc.constants.Patterns;

public class ShortReportBuilder extends ReportBuilder {
    @Override
    public void addTitle() {
        String[] text = getText();
        String title = "Last session start: " + text[0];
        report.setTitle(title);
    }

    @Override
    public void addBody() {
        String[] text = getText();
        int errors = 0;
        int requests = text.length / 2;
        for (String line : text) {
            if (line.contains(Patterns.ERROR)) {
                errors++;
            }
        }
        int successful_req = requests - errors;
        String body = "successful requests: " + successful_req + "\n"
                + "errors: " + errors;
        report.setBody(body);
    }

    @Override
    public void addEnding() {
        String[] text = getText();
        String ending = "Last session finish: " + text[text.length - 1];
        report.setEnding(ending);
    }
}
