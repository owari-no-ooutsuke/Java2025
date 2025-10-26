public class DecodeExamples {
    public static void main(String[] args) {
        //Пример 1 - работа с разными системами счисления

        //Восьмеричные числа (префикс 0)
        Integer oct = Integer.decode("0123"); //oct = 83

        //Шестнадцатеричные числа
        //префикс 0x
        Integer hex1 = Integer.decode("0x1A"); //hex1 = 26
        //префикс 0X
        Integer hex2 = Integer.decode("0XFF"); //hex2 = 255
        //префикс # (например - работа с цветами в RGB)
        Integer color = Integer.decode("#FF00FF"); //color = 16711935

        //Пример 2 - обработка ошибок

        String[] numStrings = {
                "10", //корректно
                "999999999999999999999", //слишком большое число для Integer
                "0xW" //некорректная запись
        };

        for (String numStr : numStrings) {
            try {
                Integer num = Integer.decode(numStr);
                System.out.println("\"" + numStr + "\" -> " + num);
            } catch (NumberFormatException e) {
                System.out.println("\"" + numStr + "\" -> error: " + e.getMessage());
            }
        }
    }
}