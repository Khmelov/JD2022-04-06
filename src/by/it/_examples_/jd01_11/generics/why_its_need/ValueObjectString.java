package by.it._examples_.jd01_11.generics.why_its_need;

public class ValueObjectString {

    private String value;

    public ValueObjectString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    void printToConsole() {
        System.out.println(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
