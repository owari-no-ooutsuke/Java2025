import java.util.Formatter;
import java.util.Date;

public class FormatterExampleDateTime {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);

        Date currentDate = new Date();

        //Используем %tA, %tB, %tY
        formatter.format("Текущая дата: %tA %td %tB %tY года%n", currentDate, currentDate,
                currentDate, currentDate);

        //Используем %tH, %tM
        formatter.format("Текущее время: %tH часов %tM минут", currentDate, currentDate);

        formatter.close();
    }
}
