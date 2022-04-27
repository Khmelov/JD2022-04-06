package by.it._examples_.jd01_07.abstractdemo;

public class Runner {
    public static void main(String[] args) {
        Button one = new Button(1, 2); //плохо
        one.show();
        //зачем вообще нужна абстракция:
        //1. Общее поведение. 2. Возможность замены.
        Component two = new Input(3, 4); //хорошо
        two.show();
        Component[] components = {
                new Button(5, 6),
                new Button(7, 8),
                new Input(9, 10),
        };
        for (Component component : components) {
            component.show();
        }

    }
}
















