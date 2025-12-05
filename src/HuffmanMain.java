import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Главный класс программы для кодирования и декодирования файлов по методу Хаффмана.
 * Предоставляет интерфейс для выбора операций (управляется из консоли)
 */
public class HuffmanMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputFileName;
        String outputFileName;
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Кодирование\n2. Декодирование\n3. Завершение работы");
            String command = scan.next();

            switch(command.strip()) {
                case "1":
                    System.out.println("Введите название входного файла:");
                    inputFileName = scan.next();
                    System.out.println("Введите название выходного файла:");
                    outputFileName = scan.next();
                    encodeFile(inputFileName, outputFileName);
                    break;
                case "2":
                    System.out.println("Введите название файла:");
                    inputFileName = scan.next();
                    System.out.println("Введите название выходного файла:");
                    outputFileName = scan.next();
                    decodeFile(inputFileName, outputFileName);
                    break;
                case "3":
                    scan.close();
                    exit = true;
                    break;
                default:
                    System.out.println("Такой команды нет!");
            }
        }
    }

    /**
     * Кодирование файла
     *
     * @param inputFileName имя входного файла
     * @param outputFileName имя выходного файла
     */
    private static void encodeFile(String inputFileName, String outputFileName) {
        try (FileInputStream fin = new FileInputStream(inputFileName); FileOutputStream fout =
                new FileOutputStream(outputFileName)) {
            Encoder encoder = new Encoder(fin, fout);
            encoder.process();
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    /**
     * Декодирование файла
     *
     * @param inputFileName имя входного файла
     * @param outputFileName имя выходного файла
     */
    private static void decodeFile(String inputFileName, String outputFileName) {
        try (FileInputStream fin = new FileInputStream(inputFileName); FileOutputStream fout =
                new FileOutputStream(outputFileName)) {
            Decoder decoder = new Decoder(fin, fout);
            decoder.process();
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}