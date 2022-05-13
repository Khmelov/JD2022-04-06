package by.it._examples_.jd01_11.generics.why_its_need;

public class ValueObjectCharacter {

    private Character value;

    public ValueObjectCharacter(Character value) {
        this.value = value;
    }

    public Character getValue() {
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
