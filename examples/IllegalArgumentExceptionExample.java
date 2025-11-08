class Person {
    private int age;

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0) {
            //Выбрасываем исключение IllegalArgumentException
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        else {
            this.age = age;
        }
    }

}

public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person.setAge(-10); //Передаем отрицательный возраст
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
