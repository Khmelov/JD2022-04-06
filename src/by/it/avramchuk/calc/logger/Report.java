package by.it.avramchuk.calc.logger;

public class Report {
    private String title="";
    private String body="";
    private String ending="";

    public void setTitle(String title){
        this.title = title;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setEnding(String ending){
        this.ending = ending;
    }

    @Override
    public String toString() {
        return title+"\n"
                +body+"\n"
                +ending+"\n";
    }
}
