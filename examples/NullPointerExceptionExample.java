public class NullPointerExceptionExample {
    public static void main(String[] args) {
        try {
            String str = null;
            str.toLowerCase();
        }
        catch (NullPointerException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
