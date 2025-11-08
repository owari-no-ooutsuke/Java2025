public class StringConversion {
    public static void main(String[] args) {
        String str = "string text";
        StringBuffer buffer = new StringBuffer("buffer text");
        StringBuilder builder = new StringBuilder("builder text");

        //String -> StringBuffer
        StringBuffer strToBuffer = new StringBuffer(str);

        //String -> StringBuilder
        StringBuilder strToBuilder = new StringBuilder(str);

        //StringBuffer -> String
        String bufferToString1 = buffer.toString(); //Через toString()
        String bufferToString2 = String.valueOf(buffer); //Через String.valueOf(Object obj)
        String bufferToString3 = "" + buffer; //Через конкатенацию

        //StringBuilder -> String
        String builderToString1 = builder.toString(); //Через toString()
        String builderToString2 = String.valueOf(builder); //Через String.valueOf(Object obj)
        String builderToString3 = "" + builder; //Через конкатенацию

        //StringBuffer -> StringBuilder
        StringBuilder bufferToBuilder = new StringBuilder(buffer);

        //StringBuilder -> StringBuffer
        StringBuffer builderToBuffer = new StringBuffer(builder);
    }
}
