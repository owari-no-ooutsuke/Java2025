//Иерархия с нарушением принципа подстановки Лисков

class BadRectangle {
    protected int width;
    protected int height;

    public BadRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}


class BadSquare extends BadRectangle {

    public BadSquare(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class RectangleProcessor {
    public int exampleMethod(BadRectangle r, int width, int height) {
        r.setWidth(width);
        r.setHeight(height); //Здесь при передаче в качестве r объекта класса BadSquare меняются и width, и height
        return r.getArea();
    }
}

//Иерархия, соответствующая принципу подстановки Лисков

interface Shape {
    int getArea();
}


class GoodRectangle implements Shape {
    private int width;
    private int height;

    public GoodRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}


class GoodSquare implements Shape {
    private int side;

    public GoodSquare(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}


public class LiskovExample{
    public static void main(String[] args) {
        BadSquare sq = new BadSquare(5);
        RectangleProcessor pr = new RectangleProcessor();
        System.out.print("\nДемонстрация нарушения:\n\n" +
                "Параметры: width = 10, height = 20\n" +
                "Ожидаемая площадь: 200\n" +
                "Реальная площадь:" + pr.exampleMethod(sq, 10, 20));
    }
}