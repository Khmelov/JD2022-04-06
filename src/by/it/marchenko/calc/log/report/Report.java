package by.it.marchenko.calc.log.report;

import static by.it.marchenko.calc.constant.MessageConst.NEW_LINE;

public class Report {
    private String header = "";
    private String body = "";
    private String footer = "";

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return header + NEW_LINE +
                body + NEW_LINE +
                footer;
    }
}
