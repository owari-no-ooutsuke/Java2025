import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class StringJoinerExamples {

    //Пример 1 - создание пути к файлу (Windows) из частей
    public static String buildFilePath(String... pathParts) {
        StringJoiner path = new StringJoiner("\\"); //разделитель - '\'
        for (String part : pathParts) {
            if (part != null && !part.trim().isEmpty()) {
                path.add(part.trim()); //добавляем строку в StringJoiner
            }
        }
        return path.toString();
    }

    //Пример 2 - создание условия WHERE в SQL
    public static String buildWhereClause(Map<String, Object> conditions) {
        if (conditions == null || conditions.isEmpty()) {
            return "";
        }
        //разделитель - " AND ", префикс - "WHERE ", суффикс пустой
        StringJoiner whereClause = new StringJoiner(" AND ", "WHERE ", "");
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            String condition = entry.getKey() + " = '" + entry.getValue() + "'"; //формируем строку с условием
            whereClause.add(condition); //добавляем строку в StringJoiner
        }
        return whereClause.toString();
    }

    public static void main(String[] args) {
        String filePath = buildFilePath("C:", "Users", "user");
        System.out.println(filePath);

        Map<String, Object> conditions = new HashMap<>();
        conditions.put("age", 20);
        conditions.put("university", "СПбПУ");
        String whereClause = buildWhereClause(conditions);
        System.out.println(whereClause);
    }
}
