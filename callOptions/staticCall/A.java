package staticCall;

public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }

    //Вызов из методов того же класса - без имени класса
    //Из статического метода
    public static void staticMethod() {
        printVars();
    }

    //Из нестатического метода
    public void instanceMethod() {
        printVars();
    }
}
