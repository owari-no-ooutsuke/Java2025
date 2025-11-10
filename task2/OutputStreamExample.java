import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {
    public static void main(String[] args) {
        String str = "Hello, world!";

        //FileOutputStream - подкласс OutputStream, предназначенный для записи в файл
        try (FileOutputStream fos = new FileOutputStream("output_file.txt")) {
            for (int i = 0; i < str.length(); i++) {
                //Записываем строку по символам
                int num = str.charAt(i);
                fos.write(num);
            }
            System.out.println("Запись в файл завершена!");
        }
        catch (IOException e) {
            System.out.println("Ошибка при записи в файл! " + e.getMessage());
        }
    }
}
