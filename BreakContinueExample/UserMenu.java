import java.util.Scanner;

//меню пользователя
public class UserMenu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int command;

        //бесконечный цикл do-while, условие выхода - команда 3
        do {
            System.out.println("\nВведите команду:\n1. Показать профиль\n2. " +
                    "Изменить настройки\n3. Выйти");

            command = in.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Профиль пользователя...");
                    break;
                case 2:
                    System.out.println("Настройки...");
                    break;
                case 3:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Такой команды нет, попробуйте снова");
                    continue; //переходим на следующую итерацию цикла
            }

            if (command == 3) {
                break; //команда "выйти" - выходим из цикла
            }

        } while (true);

        System.out.println("Программа завершена");
        in.close();
    }
}
