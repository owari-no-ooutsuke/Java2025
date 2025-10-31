class ComplexNumber {
    public double re;
    public double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    //Хотим сравнивать не ссылки, а значения (по определению равенства комплексных чисел)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        ComplexNumber num = (ComplexNumber)obj;
        return (re == num.re) && (im == num.im);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(re, im);
    }

    //Запись в строку комплексного числа в алгебраической форме
    @Override
    public String toString() {
        return re + " + " + im + " * i";
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 1.5);
        ComplexNumber b = new ComplexNumber(1, 1.5);

        System.out.println("Первое число: " + a.toString());
        System.out.println("Второе число: " + b.toString());
        System.out.println("Проверка равенства через ==: " + (a == b));
        System.out.println("Проверка равенства через equals: " + a.equals(b));
    }
}