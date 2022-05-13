package by.it._examples_.jd01_11.generics.why_its_need;

public class ValueObjectBoolean {

    private Boolean value;

    public ValueObjectBoolean(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
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
