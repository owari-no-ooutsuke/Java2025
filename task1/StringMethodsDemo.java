import java.util.Arrays;

public class StringMethodsDemo {
    public static void main(String[] args) {
        String str = "Hello, world! (^_^;)";
        System.out.println("Исходная строка: " + str);

        //1. length() - возвращает длину строки
        int len = str.length();
        System.out.println("1. length(): " + len);

        //2. toUpperCase() - преобразование регистра
        String upperStr = str.toUpperCase();
        System.out.println("2. toUpperCase(): " + upperStr);

        //3. contains(CharSequence s) - проверка наличия подстроки
        boolean containsSubstring = str.contains("world");
        System.out.println("3. contains(\"world\"): " + containsSubstring);

        //4. substring(int beginIndex, int endIndex) - извлечение подстроки
        String subStr = str.substring(1, 10);
        System.out.println("4. substring(1, 10): " + subStr);

        //5. startsWith(String prefix) - проверка начала
        boolean startsWith = str.startsWith("Hell");
        System.out.println("5. startsWith(\"Hell\"): " + startsWith);

        //6. charAt(int index) - возвращает символ с индексом index
        char chr = str.charAt(12);
        System.out.println("6. charAt(12): " + chr);

        //7. replace(char oldChar, char newChar) - заменяет все вхождения oldChar на newChar
        String newStr = str.replace('^', '*');
        System.out.println("7. replace('^', '*'): " + newStr);

        //8. concat(String str) - конкатенация строк (создает новую строку, исходная не меняется)
        String concatenated = str.concat("Java");
        System.out.println("8. concat(\"Java\"): " + concatenated);

        //9. split(String regex)
        //разделение строки на массив подстрок по разделителю, заданному регулярным выражением
        String[] subStrings = str.split(" ");
        System.out.println("9. split(\" \"): " + Arrays.toString(subStrings));

        //10. indexOf(String str)
        //возвращает индекс первого символа подстроки или -1, если такой подстроки в строке нет
        int index = str.indexOf("world");
        System.out.println("10. indexOf(\"world\"): " + index);
        index = str.indexOf("Java");
        System.out.println("indexOf(\"Java\"): " + index);
    }
}
