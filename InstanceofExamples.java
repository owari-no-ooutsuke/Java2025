class Car {

    public void gas() {
        //...газ
    }

    public void brake() {
        //...тормоз
    }
}


class F1Car extends Car {

    public void pitStop() {
        //...пит-стоп
    }
}

public class InstanceofExamples {
    public static void main(String[] args) {
        Object obj = "134";
        boolean isInteger = obj instanceof Integer; //isInteger = false

        F1Car formula1Car = new F1Car();
        boolean isCar = formula1Car instanceof Car; //isCar = true

        String nullStr = null;
        boolean isString = nullStr instanceof String; //isString = false (с null всегда false)
    }
}