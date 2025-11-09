//Иерархия исключений: RuntimeException <- IllegalArgumentException <- NumberFormatException

class Person {
    private int age;

    public int getAge() { return age; }

    public void setAge(String ageStr) {
        ageStr = ageStr.trim(); //Может выбрасывать NullPointerException (наследуется от RuntimeException)
        int age = Integer.parseInt(ageStr); //Может выбрасывать NumberFormatException

        if (age < 0) {
            //Выбрасываем исключение IllegalArgumentException
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        else {
            this.age = age;
        }
    }

}

public class ExceptionHierarchyExample {
    public static void main(String[] args) {
        Person person = new Person();
        String[] testAges = {"20", "-2", "twelve", null};

        for (String ageStr : testAges) {
            try {
                person.setAge(ageStr);
            }
            //В иерархии Ex1 <- Ex2 <- Ex3 сначала обрабатываем Ex3, потом Ex2, потом Ex1
            catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + e.getMessage());
            }
            catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException: " + e.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println("Some other RuntimeException: " + e.getMessage());
            }
        }
    }
}
