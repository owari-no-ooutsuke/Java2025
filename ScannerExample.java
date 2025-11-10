import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        String filename = "output_file.txt";
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filename))) {
            //Читаем текст из файла построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line).append("\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        System.out.println("Прочитано:\n" + stringBuilder);
    }
}
