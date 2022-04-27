package by.it._examples_.jd01_07.interfacedemo;

class Runner {
    public static void main(String[] args) {
        ToolPanel panel = new ToolPanel();
        panel.doubleClick();
        Clickable element = new Button(); //Абстракция имя=new Реализация();
        element.click(); //при вызове метода поиск начинается в реализации
        element.doubleClick(); //а если метод не найден, то они ищется в предках и интерфейсах
        System.out.printf("Max=%d\n", Clickable.MAX_COUNT);
    }
}