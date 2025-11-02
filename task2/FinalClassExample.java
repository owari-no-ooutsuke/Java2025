//final класс
final class StringProcessor {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}

//Попытка создать наследника final класса - ошибка компиляции
/*
class CoolerStringProcessor extends StringProcessor {

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
 */