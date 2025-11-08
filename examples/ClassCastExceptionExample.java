import java.util.ArrayList;
import java.util.List;

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        List<Object> mixedList = new ArrayList<>();
        mixedList.add("Строка");
        mixedList.add(42);

        for (Object obj : mixedList) {
            try {
                String str = (String)obj; //Для 42 будет приведение Integer к String - невозможно привести
            }
            catch (ClassCastException e) {
                System.out.println("Ошибка! " + e.getMessage());
            }
        }
    }
}
