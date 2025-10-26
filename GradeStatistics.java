import java.util.Arrays;

public class GradeStatistics {
    public static void main(String[] args) {
        //массив оценок студентов
        int[] grades = {3, 4, 5, 3, 4, 5, 5, 2, 3, 4, 5, 2};

        //Вывод исходных данных
        System.out.println("Исходные оценки: " + Arrays.toString(grades));

        //Сортировка
        Arrays.sort(grades);
        System.out.println("Отсортированные оценки: " + Arrays.toString(grades));

        //Поиск конкретной оценки
        int grade = 5;
        int index = Arrays.binarySearch(grades, grade);
        if (index >= 0) {
            System.out.println("Оценка " + grade + " найдена на позиции " + index
                    + " в отсортированном массиве");
        } else {
            System.out.println("Оценка " + grade + " не найдена");
        }

        //Сравнение с оценками за предыдущий семестр
        int[] previousGrades = {4, 4, 2, 3, 3, 5, 5, 2, 3, 4, 5, 3};
        Arrays.sort(previousGrades);

        boolean areEqual = Arrays.equals(grades, previousGrades);
        if (areEqual) {
            System.out.print("Оценки идентичны предыдущим");
        } else {
            System.out.print("Оценки отличаются от предыдущих: ");
            int comp = Arrays.compare(grades, previousGrades);
            System.out.print((comp > 0) ? "текущие лучше" : "предыдущие лучше");
        }
    }
}