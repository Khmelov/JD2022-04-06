package by.it._examples_.jd01_09.inner;


public class ParentClass {
    // abstract, final, private, protected - допустимы
    @SuppressWarnings("InnerClassMayBeStatic")
    class SubClass { // определение внутреннего (inner) класса
        // тут поля и методы
        void launch() {
            System.out.println("SubClass работает");
        }
    } // конец объявления внутреннего класса

    public final void init() { // метод внешнего класса ParentClass
        System.out.println("init ParentClass");
        // поля и конструкторы
        SubClass eng = new SubClass();
        eng.launch();
    }
}