import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamExample {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        //FileInputStream - подкласс InputStream, предназначенный для чтения из файла
        try (FileInputStream fin = new FileInputStream("input_file.txt")) {
            int i;
            //Читаем отдельный байт, пока есть данные для чтения
            while((i = fin.read()) != -1) {
                stringBuilder.append((char)i); //Добавляем символ в строку
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка при чтении из файла! " + e.getMessage());
        }

        System.out.println("Прочитана строка: " + stringBuilder);
    }
}
