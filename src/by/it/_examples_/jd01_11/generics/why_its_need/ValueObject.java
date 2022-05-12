package by.it._examples_.jd01_11.generics.why_its_need;

public class ValueObject<T> {

    private T value;

    public ValueObject(T value) {
        this.value = value;
    }

    public T getValue() {
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
