public class PlanetCalculator {

    public enum Planet {
        //Инициализация элементов перечисления
        MERCURY(3.303e+23, 2.4397e6, "Меркурий"),
        VENUS(4.869e+24, 6.0518e6, "Венера"),
        EARTH(5.976e+24, 6.37814e6, "Земля"),
        MARS(6.421e+23, 3.3972e6, "Марс"),
        JUPITER(1.9e+27, 7.1492e7, "Юпитер"),
        SATURN(5.688e+26, 6.0268e7, "Сатурн"),
        URANUS(8.686e+25, 2.5559e7, "Уран"),
        NEPTUNE(1.024e+26, 2.4746e7, "Нептун");

        public final double mass; //Масса планеты (в кг)
        public final double radius; //Радиус планеты (в м)
        public final String name; //Название планеты

        //Конструктор перечисления
        Planet(double mass, double radius, String name) {
            this.mass = mass;
            this.radius = radius;
            this.name = name;
        }

    }

    public static final double G = 6.67300E-11; //Гравитационная постоянная

    //Расчет веса тела на всех планетах с выводом в консоль
    public static void surfaceWeights(double otherMass) {
        for (Planet planet : Planet.values()) {
            System.out.println("Вес тела массой " + otherMass + " кг на планете " + planet.name + " : " +
                    otherMass * G * planet.mass / (planet.radius * planet.radius));
        }
    }

    public static void main(String[] args) {
        surfaceWeights(10);
    }
}

