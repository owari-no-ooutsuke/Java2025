public class DiffTypeOperations {
    public static void main(String[] args) {
        double d = 3 / 2.0; //Результат: double 1.5
        //int 3 приводится к double 3.0, т.к. double - больший тип

        byte b = 10;
        int a = 1000;
        int c = b + a; //Результат: int 1010
        //byte приводится к int, т.к. int - больший тип

        long l = 10L;
        float f = 0.6f;
        float r = l + f; //Результат: float 10.6f
        //long 10L приводится к float 10.0f, т.к. float - больший тип
        }
}