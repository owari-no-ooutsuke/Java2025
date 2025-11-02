public class WeekManager {

    public enum DayOfWeek {
        MONDAY("Понедельник"),
        TUESDAY("Вторник"),
        WEDNESDAY("Среда"),
        THURSDAY("Четверг"),
        FRIDAY("Пятница"),
        SATURDAY("Суббота"),
        SUNDAY("Воскресенье");

        private final String name;

        DayOfWeek(String name) {
            this.name = name;
        }

        //Геттер для названия дня недели
        public String getName() { return name; }

        //Сколько дней до дня target
        public int daysUntil(DayOfWeek target) {
            int diff = target.ordinal() - this.ordinal();
            return diff >= 0 ? diff : diff + 7;
        }
    }

    //Демонстрация работы методов
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.FRIDAY;
        int untilTuesday = day.daysUntil(DayOfWeek.TUESDAY);
        System.out.print("От дня " + day.getName() + " до дня " + DayOfWeek.TUESDAY.getName() +
                " " + untilTuesday + " д.");
    }
}

