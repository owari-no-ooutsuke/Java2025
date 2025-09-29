public class StringExample {
    public static void main(String[] args) {
        String s = "Hello";
        int a = 15;
        Character c = '!';

        String s1 = s + a; //Результат: "Hello15"
        String s2 = s + c; //Результат: "Hello!"
        String s3 = s + null; //Результат: "Hellonull"
    }
}