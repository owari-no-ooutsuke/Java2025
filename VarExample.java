import java.util.List;

public class VarExample {
    public static void main(String[] args) {

        var names = List.of("Alice", "Bob", "Tom"); //Вместо List<String>
        for (var name : names) { //Вместо String
            System.out.println(name);
        }

        //Использование var укорачивает код
        //В данном примере тип очевиден из контекста, var не ухудшает читаемость кода
    }
}