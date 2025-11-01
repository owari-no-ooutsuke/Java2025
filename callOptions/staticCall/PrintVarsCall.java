package staticCall;

public class PrintVarsCall {
    public static void main(String[] args) {
        //Через имя класса (без создания экземпляра класса) - рекомендуемый вариант
        A.printVars();

        //Через объект класса
        A a = new A();
        a.printVars();
    }
}