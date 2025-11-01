import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}

class Student extends Person {
    private String university;

    public Student(String name, int height, String university) {
        super(name, height);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }
}

class GraduateStudent extends Student {
    private int thesisGrade;

    public GraduateStudent(String name, int height, String university, int thesisGrade) {
        super(name, height, university);
        this.thesisGrade = thesisGrade;
    }

    public int getThesisGrade() {
        return thesisGrade;
    }
}

public class ExtendsSuperExample {

    //Использование <? extends T>
    //Можем применять этот метод как к List<Person> так и к List<Student> и List<GraduateStudent>
    public static double averageHeight(List<? extends Person> people) {
        double totalHeight = 0;
        //Знаем, что p класса Person или его наследника - можем безопасно читать
        for (Person p : people) {
            totalHeight += p.getHeight();
        }
        return totalHeight / people.size();
    }

    //Использование <? super T>
    //Можем сортировать List<T> компаратором как для T, так и для его суперклассов
    public static <T> void sortByComparator(List<T> list, Comparator<? super T> comparator) {
        //Сортируем (тут могла бы быть пользовательская сортировка)
        list.sort(comparator);
    }

    //Использование <? super T>
    //Можем записывать результат как в List<GraduateStudent>, так и в List любого суперкласса
    public static void filterByThesisGrade(List<GraduateStudent> from, List<? super GraduateStudent> to,
                                           int minGrade) {
        for (GraduateStudent st : from) {
            //st - список объектов класса GraduateStudent или суперкласса - можем безопасно записывать
            if (st.getThesisGrade() >= minGrade) {
                to.add(st);
            }
        }
    }

    public static void main(String[] args) {
        List<GraduateStudent> graduateStudents = Arrays.asList(new GraduateStudent("Иван", 175,
                        "СПбПУ", 3), new GraduateStudent("Мария", 167,
                        "СПбПУ", 5), new GraduateStudent("Василий", 181,
                "ИТМО", 5));

        //Применяем averageHeight(List<? extends Person> people) к List<GraduateStudent>
        double avgHeight = averageHeight(graduateStudents);
        System.out.println("Средний рост: " + avgHeight + " см");

        //Будем сравнивать людей по росту
        Comparator<Person> byHeight = Comparator.comparingInt(Person::getHeight);

        //Применяем Comparator<Person> для сортировки List<GraduateStudent>
        sortByComparator(graduateStudents, byHeight);
        System.out.print("Студенты по росту (в порядке возрастания): ");
        for (Student st : graduateStudents) {
            System.out.print(st.getName() + " ");
        }

        List<Student> students = new ArrayList<>();
        //Отфильтруем graduateStudents по оценке за диплом и запишем в students
        //(информация об их оценках за диплом, допустим, нам далее не понадобится)
        filterByThesisGrade(graduateStudents, students, 5);
        System.out.print("\nОтличники и хорошисты: ");
        for (Student st : students) {
            System.out.print(st.getName() + " ");
        }

    }
}
