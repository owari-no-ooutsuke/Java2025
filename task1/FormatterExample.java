import java.util.Formatter;

public class FormatterExample {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);

        int a = 2;
        int b = 35;
        double percent = (double)a / b * 100;
        //Используем %d, %f, %%
        formatter.format("Число %d составляет %f%% от числа %d", a, percent, b);

        String word = "hello";
        //Используем %n, %c
        formatter.format("%nПервая буква слова - %c", word.charAt(0));
    }
}
