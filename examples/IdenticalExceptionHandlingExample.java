public class IdenticalExceptionHandlingExample {
    public static void main(String[] args) {
        String[] strings = {"12", "0", "abc", null};
        int a = 48;

        for (String str : strings) {
            try {
                str = str.trim(); //Может выбрасывать NullPointerException
                int number = Integer.parseInt(str); //Может выбрасывать NumberFormatException
                if (a % number == 0) { //Может выбрасывать ArithmeticException
                    System.out.println(str + " является делителем " + a);
                }
            }
            //Ни одно из исключений не является подклассом другого, можно обрабатывать в одном блоке catch
            catch (ArithmeticException | NumberFormatException | NullPointerException e) {
                System.out.println("Ошибка! " + e.getMessage());
            }
        }
    }
}
