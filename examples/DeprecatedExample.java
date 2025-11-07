class Calculator {
    /**
     * Старый метод для сложения - используйте вместо него add()
     * @param a первое число
     * @param b второе число
     * @return сумма чисел
     * @deprecated Используйте {@link #add(int, int)} вместо этого
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public int sum(int a, int b) {
        return a + b;
    }

    //Новый метод, заменяющий устаревший
    public int add(int a, int b) {
        System.out.print(a + " + " + b + " = " + a + b);
        return a + b;
    }

    //Простое устаревание без дополнительной информации
    @Deprecated
    public void oldMethod() {
        System.out.println("old method");
    }
}

//Устаревший класс
@Deprecated
class OldDatabaseConnection {
    //устаревшая реализация
}

//Новый класс, заменяющий устаревший
class NewDatabaseConnection {
    //новая реализация
}

//Использование устаревших методов и класса
public class DeprecatedExample {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int result = calc.sum(5, 3); //Предупреждение 'sum(int, int)' is deprecated since version 2.0 and marked for removal

        calc.oldMethod(); //Предупреждение 'oldMethod()' is deprecated

        OldDatabaseConnection dbConnection = new OldDatabaseConnection(); //Предупреждение 'OldDatabaseConnection' is deprecated
    }
}
