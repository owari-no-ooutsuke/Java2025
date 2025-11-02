class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    //final метод
    public final void validate() {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    //Попытка переопределить final метод - ошибка компиляции
    /*
    @Override
    public final void validate() {  // ОШИБКА: cannot override final method
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным");
        }
        super.validate();
    }
    */
}
