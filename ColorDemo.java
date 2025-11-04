interface ColorUtils {
    //Вложенный класс
    class Color {
        private final int red, green, blue;

        public Color(int red, int green, int blue) {
            this.red = Math.max(0, Math.min(255, red));
            this.green = Math.max(0, Math.min(255, green));
            this.blue = Math.max(0, Math.min(255, blue));
        }

        //Нестатический метод
        @Override
        public String toString() {
            return "(" + red + ", " + green + ", " + blue + ")";
        }

        //Статический метод
        public static void doSthElse() {
            System.out.println("static method");
        }
    }

    public void process(Color[][] colorMatrix);
}


public class ColorDemo {
    public static void main(String[] args) {
        //Создаем экземпляр вложенного класса
        ColorUtils.Color yellow = new ColorUtils.Color(255, 255, 0);
        //Вызываем нестатический метод
        System.out.println(yellow.toString());

        //Вызываем статический метод - можно без экземпляра
        ColorUtils.Color.doSthElse();
    }
}

