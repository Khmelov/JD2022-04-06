package by.it._examples_.jd01_11.generics.why_its_need;


public class Runner {
    public static void main(String[] args) {
        //дубликация классов и кода
        new ValueObjectBoolean(false).printToConsole();
        new ValueObjectCharacter('$').printToConsole();
        new ValueObjectString("Главный вопрос...").printToConsole();

        //обобщённое решение
        new ValueObject<Boolean>(false).printToConsole();
        new ValueObject<Character>('$').printToConsole();
        new ValueObject<String>("Главный вопрос...").printToConsole();
        new ValueObject<Integer>(42).printToConsole();
        new ValueObject<Float>(42f).printToConsole();
    }
}
