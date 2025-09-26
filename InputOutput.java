import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        System.out.println("Введите имя: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        scan.close();
        System.out.println("Привет, " + name + "!");
    }
}