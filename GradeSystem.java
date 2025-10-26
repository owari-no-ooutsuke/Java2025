public class GradeSystem {
    enum Grade {EXCELLENT, GOOD, SATISFACTORY, UNSATISFACTORY};

    public static void intGrade(int grade) {
        switch(grade) {
            case 5:
                System.out.println("отлично");
                break;
            case 4:
                System.out.println("хорошо");
                break;
            case 3:
                System.out.println("удовлетворительно");
                break;
            case 2:
                System.out.println("неудовлетворительно");
                break;
            default:
                System.out.println("такой оценки нет");
        }
    }

    public static void charGrade(char grade) {
        switch(grade) {
            case 'A':
                System.out.println("отлично");
                break;
            case 'B':
            case 'C':
                System.out.println("хорошо");
                break;
            case 'D':
            case 'E':
                System.out.println("удовлетворительно");
                break;
            case 'F':
                System.out.println("неудовлетворительно");
                break;
            default:
                System.out.println("такой оценки нет");
        }
    }

    public static void enumGrade(Grade grade) {
        switch(grade) {
            case EXCELLENT:
                System.out.println("отлично");
                break;
            case GOOD:
                System.out.println("хорошо");
                break;
            case SATISFACTORY:
                System.out.println("удовлетворительно");
                break;
            case UNSATISFACTORY:
                System.out.println("неудовлетворительно");
        }
    }

    public static void stringGrade(String grade) {
        switch(grade) {
            case "отл":
                System.out.println("отлично");
                break;
            case "хор":
                System.out.println("хорошо");
                break;
            case "уд":
                System.out.println("удовлетворительно");
                break;
            case "неуд":
                System.out.println("неудовлетворительно");
                break;
            default:
                System.out.println("такой оценки нет");
        }
    }

    public static void main(String[] args) {
        intGrade(2);
        charGrade('B');
        enumGrade(Grade.SATISFACTORY);
        stringGrade("отл");
    }
}