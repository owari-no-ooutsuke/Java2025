class Shape {

    public void draw() {
        //Рисуем какую-то произвольную фигуру
    }

    public Integer calculateArea() {
        return 0;
    }

    public Shape copy() {
        return new Shape();
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    //Тип возвращаемого значения совпадает
    @Override
    public void draw() {
        //Рисуем круг
    }

    //Тип возвращаемого значения отличается: Double не является подтипом Integer
    //Ошибка компиляции!
    /*
    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }
    */

    //Тип возвращаемого значения отличается: Circle - подкласс Shape
    @Override
    public Circle copy() {
        return new Circle(radius);
    }
}