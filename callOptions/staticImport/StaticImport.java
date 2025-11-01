package staticImport;

import static staticCall.A.printVars;

//Статический импорт позволяет обращаться к статическим методам без указания имени класса
public class StaticImport {
    public static void main(String[] args) {
        printVars();
    }
}
