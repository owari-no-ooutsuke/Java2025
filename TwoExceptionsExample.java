public class TwoExceptionsExample {
    public static Integer divideIntFromString(String dividend, String divisor) {
        int a = Integer.parseInt(dividend); //Может выбрасывать NumberFormatException - не обрабатываем
        int b = Integer.parseInt(divisor);

        try {
            return a / b; //Может выбрасывать ArithmeticException - обрабатываем
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка! " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        //Будет выброшено ArithmeticException - обрабатываем
        Integer zeroDivisionRes = divideIntFromString("10", "0");

        //Будет выброшено NumberFormatException - приведет к аварийной остановке
        Integer incorrectFormatRes = divideIntFromString("abc", "2");

        System.out.println("success!"); //Не будет выполнено
    }

}
