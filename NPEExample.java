import java.util.HashMap;
import java.util.Map;

public class NPEExample {
    public static void main(String[] args) {

        Map<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Alice", 5);
        studentGrades.put("Bob", 4);

        String[] studentNames = {"Alice", "Bob", "Charlie"}; //ключа "Charlie" в studentGrades нет

        //хотим вывести оценку для каждого студента из studentNames
        for (String name : studentNames) {
            try {
                int grade = studentGrades.get(name); //studentGrades.get("Charlie") вернет null
                System.out.println(name + ": " + grade);
            } catch (NullPointerException e) {
                System.out.println("No grade for " + name + "!");
            }
        }
    }
}