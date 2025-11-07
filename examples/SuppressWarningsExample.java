import java.util.ArrayList;
import java.util.List;

class Machine {
    private List versions;

    //Подавление unchecked предупреждений
    @SuppressWarnings("unchecked")
    public void addVersion(String version) {
        versions.add(version); //Без аннотации будет предупреждение Unchecked call to 'add(E)'...
    }

    //Подавление нескольких типов предупреждений
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void processData() {
        List rawList = new ArrayList();  //Без аннотации будет предупреждение Raw use of parameterized class...
        List<String> stringList = (List<String>) rawList;  //Без аннотации будет предупреждение Unchecked cast...
    }

    //Подавление для блока кода
    public void specificBlock() {
        List rawList = new ArrayList();

        @SuppressWarnings("unchecked")
        List<String> converted = (List<String>) rawList; //Без аннотации будет предупреждение Unchecked cast...

        //Дальнейшая работа с converted...
    }

    @Deprecated
    public void oldMethod() {
        System.out.println("old method");
    }
}


//Подавление на уровне класса
@SuppressWarnings("deprecation")
class LegacyCodeUser {
    public void useLegacyFeatures() {
        Machine machine = new Machine();
        machine.oldMethod(); //Без аннотации будет предупреждение 'oldMethod()' is deprecated
    }
}
