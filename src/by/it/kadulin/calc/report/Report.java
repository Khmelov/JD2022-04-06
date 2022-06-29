package by.it.kadulin.calc.report;

public class Report {
    private String title;
    private String timeDateCreate;
    private StringBuilder content = new StringBuilder();

    public Report() {

    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeDateCreate(String timeDateCreate) {
        this.timeDateCreate = timeDateCreate;
    }

    public String getContent() {
        return content.toString();
    }

    public void contentAdd(String text) {
        content.append(text).append("\n");
    }

    @Override
    public String toString() {
        return "Report:" + title + "\n" + timeDateCreate + '\n' + content.toString();
    }
}
