public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 1 / a; //Деление на 0
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
