class TextProcessor {

    //Конкатенация строк
    public String concatenate(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    //Конкатенация строк с добавлением разделителя
    public String concatenate(String delimiter, String... strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i != strings.length - 1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    //Конкатенация символов
    public String concatenate(char... chars) {
        return new String(chars);
    }
}

public class TextProcessorExample {
    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();

        String[] text = {"hello", "world"};
        //Вызываем concatenate(String... strings)
        String res1 = textProcessor.concatenate(text);
        System.out.println(res1);

        //Вызываем concatenate(String delimiter, String... strings)
        String res2 = textProcessor.concatenate(", ", text);
        System.out.println(res2);

        //Вызываем concatenate(char... chars)
        String res3 = textProcessor.concatenate('a', 'b', 'c', 'd');
        System.out.println(res3);
    }
}
