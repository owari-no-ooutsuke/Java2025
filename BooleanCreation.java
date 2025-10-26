public class BooleanCreation {
    public static void main(String[] args) {

        //через valueOf от boolean
        Boolean bool1 = Boolean.valueOf(true);

        //через valueOf от String
        Boolean bool2 = Boolean.valueOf("true"); //можно также "TRUE" или "True"

        //через parseBoolean(String s)
        Boolean bool3 = Boolean.parseBoolean("true");

        //через константы Boolean.TRUE, Boolean.FALSE
        Boolean bool4 = Boolean.TRUE;
    }
}