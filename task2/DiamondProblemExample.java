//Два интерфейса с одинаковыми неабстрактными методами
interface Writer {
    default void write(String text) {
        System.out.println("Writing to file: " + text);
    }
}

interface Printer {
    default void write(String text) {
        System.out.println("Printing document: " + text);
    }
}

/*
class MultiFunctionDevice implements Writer, Printer {
    //Компилятор не знает, какой метод выбрать - ошибка компиляции
}
 */


//Решение проблемы - переопределение конфликтующего метода
class MultiFunctionDevice implements Writer, Printer {

    //Переопределяем конфликтующий метод
    @Override
    public void write(String text) {
        System.out.println("MultiFunctionDevice processing: " + text);

        System.out.print("Writer: ");
        Writer.super.write(text);

        System.out.print("Printer: ");
        Printer.super.write(text);
    }
}
