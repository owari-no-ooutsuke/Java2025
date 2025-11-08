public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};

        try {
            for (int i = 0; i <= numbers.length; i++) {
                numbers[i]++; //Выход за границы массива при i = numbers.length
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
