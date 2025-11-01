public class A {
    //Инициализация при объявлении
    public final int a = 1;

    //Инициализация в конструкторе
    public final int b;
    public A() {
        this.b = 2;
    }

    //Инициализация в логическом блоке
    public final int c;
    {
        c = 3;
    }
}
