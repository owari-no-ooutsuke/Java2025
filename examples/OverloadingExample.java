class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int a = 1;
        int b = 10;
        int s = calc.sum(a, b); //вызывается метод sum(int a, int b)
        System.out.println("Сумма двух чисел: " + s);

        int[] numbers = {1, 2, 3, 4, 5};
        s = calc.sum(numbers); //вызывается метод sum(int[] numbers)
        System.out.println("Сумма массива: " + s);
    }
}