public class StringBufferBuilderMethodsDemo {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello, world");
        StringBuilder builder = new StringBuilder("Hello, world");
        System.out.println("Исходный StringBuffer buffer: " + buffer);
        System.out.println("Исходный StringBuilder builder: " + builder);

        //1. append (с разными типами данных) - добавление в конец
        buffer.append("!!");
        builder.append(123);
        System.out.println("\n1. append (с разными типами данных)");
        System.out.println("buffer.append(\"!!\"): " + buffer);
        System.out.println("builder.append(123): " + builder);

        //2. insert (с разными типами данных) - вставка на указанную позицию
        //Первый аргумент - индекс, второй - что вставляем
        buffer.insert(7, 1.1);
        builder.insert(7, "Java ");
        System.out.println("\n2. insert (с разными типами данных)");
        System.out.println("buffer.insert(7, 1.1): " + buffer);
        System.out.println("builder.insert(7, \"Java \"): " + builder);

        //3. delete(int start, int end)
        //Удаляет подстроку от индекса start до индекса end
        buffer.delete(7, 10);
        builder.delete(7, 12);
        System.out.println("\n3. delete(int start, int end)");
        System.out.println("buffer.delete(7, 10): " + buffer);
        System.out.println("builder.delete(7, 12): " + builder);

        //4. replace(int start, int end, String str)
        //Заменяет подстроку от start до end на str
        buffer.replace(12, 14, " \\(^_^)/");
        builder.replace(7, 15, "Java");
        System.out.println("\n4. replace(int start, int end, String str)");
        System.out.println("buffer.replace(12, 14, \" \\\\(^_^)/\"): " + buffer);
        System.out.println("builder.replace(7, 15, \"Java\"): " + builder);

        //5. setCharAt(int index, char ch)
        //Устанавливает символ ch по индексу index
        buffer.setCharAt(0, 'h');
        builder.setCharAt(8, '@');
        System.out.println("\n5. setCharAt(int index, char ch)");
        System.out.println("buffer.setCharAt(0, 'h'): " + buffer);
        System.out.println("builder.setCharAt(8, '@'): " + builder);

        //6. indexOf(String str)
        //Возвращает индекс первого символа подстроки или -1, если такой подстроки в строке нет
        int bufferIndex = buffer.indexOf("ll"); //такая подстрока есть
        int builderIndex = builder.indexOf("world"); //такой подстроки нет
        System.out.println("\n6. indexOf(String str)");
        System.out.println("buffer.indexOf(\"ll\"): " + bufferIndex);
        System.out.println("builder.indexOf(\"world\"): " + builderIndex);

        //7. substring(int start, int end)
        //Возвращает подстроку от индекса start до индекса end
        String bufferSubstring = buffer.substring(1, 3);
        String builderSubstring = builder.substring(7, 10);
        System.out.println("\n7. substring(int start, int end)");
        System.out.println("buffer.substring(1, 3): " + bufferSubstring);
        System.out.println("builder.substring(7, 10): " + builderSubstring);

        //8. setLength(int newLength) - изменение длины строки
        //Усекает или дополняет нулевыми символами ('\u0000')
        buffer.setLength(5); //новая длина меньше старой
        builder.setLength(20); //новая длина больше старой
        System.out.println("\n8. setLength(int newLength)");
        System.out.println("buffer.setLength(5): " + buffer);
        System.out.println("builder.setLength(8): " + builder);

        //9. isEmpty() - проверка на пустоту
        boolean bufferEmpty = buffer.isEmpty();
        boolean builderEmpty = builder.isEmpty();
        System.out.println("\n9. isEmpty()");
        System.out.println("buffer.isEmpty(): " + bufferEmpty);
        System.out.println("builder.isEmpty(): " + builderEmpty);

        //10. reverse() - разворот строки задом наперед
        buffer.reverse();
        builder.reverse();
        System.out.println("\n10. reverse()");
        System.out.println("buffer.reverse(): " + buffer);
        System.out.println("builder.reverse(): " + builder);
    }
}
