// Интерфейс с default и static методами
interface StringProcessor {

    //Абстрактный метод
    String process(String input);

    //Неабстрактный метод
    default String processWithOutput(String input) {
        System.out.println("Обработка строки: " + input);
        String result = process(input);
        System.out.println("Результат: " + result);
        return result;
    }

    //Статический метод
    static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }
}

//Класс, реализующий интерфейс
class UpperCaseProcessor implements StringProcessor {

    @Override
    public String process(String input) {
        if (input == null) return "";
        return input.toUpperCase();
    }
}

public class InterfaceMethodsDemo {
    public static void main(String[] args) {
        //Создаем экземпляр класса, реализующего интерфейс
        StringProcessor upperProcessor = new UpperCaseProcessor();

        //Вызов реализации абстрактного метода
        String result1 = upperProcessor.process("hello world");

        //Вызов неабстрактного метода
        String result2 = upperProcessor.processWithOutput("java");

        //Вызов статического метода
        boolean isValid = StringProcessor.isValidString("test"); //Через имя интерфейса
    }
}
