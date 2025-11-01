import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

//Параметризованный класс
class Container<T> {
    private T contents;

    public void set(T contents) {
        this.contents = contents;
    }

    public T get() {
        return contents;
    }
}

public class InstanceofGeneric {
    public static void main(String[] args) {
        Container<Integer> integerContainer = new Container<>();
        integerContainer.set(10);

        System.out.println("integerContainer instanceof Container: " +
                (integerContainer instanceof Container)); //true
        System.out.println("integerContainer instanceof Container<?>: " +
                (integerContainer instanceof Container<?>)); //true
        //System.out.println("integerContainer instanceof Container<String>: " +
                //(integerContainer instanceof Container<String>)); //Не скомпилируется


        List<String> stringList = Arrays.asList("hello", "goodbye");

        System.out.println("stringList instanceof List: " +
                (stringList instanceof List)); //true
        System.out.println("stringList instanceof List<?>: " +
                (stringList instanceof List<?>)); //true
        System.out.println("stringList instanceof ArrayDeque<?>: " +
                (stringList instanceof ArrayDeque<?>)); //false
        //System.out.println("stringList instanceof List<Object>: " +
                //(stringList instanceof List<Object>)); //Не скомпилируется
    }
}
