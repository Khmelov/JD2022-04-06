package by.it.avramchuk.calc.logger;

public class DetailReportBuilder extends ReportBuilder {
    @Override
    public void addTitle() {
        String[] text = getText();
        String title = "Last session start: " + text[0];
        report.setTitle(title);
    }

    @Override
    public void addBody() {
        StringBuilder body = new StringBuilder();
        String[] text = getText();
        for (int i = 1; i < text.length - 2; i++) {
            String[] partsOfLine = text[i].split(">", 2);
            body.append(partsOfLine[0]);
            if (i % 2 != 0) {
                body.append("Input: ").append(partsOfLine[1]).append("\n");
            } else {
                body.append("Answer: ").append(partsOfLine[1]).append("\n");
            }
        }
        report.setBody(body.toString());
    }

    @Override
    public void addEnding() {
        String[] text = getText();
        String ending = "Last session finish: " + text[text.length - 1];
        report.setEnding(ending);
    }
}
