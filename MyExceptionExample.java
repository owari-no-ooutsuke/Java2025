//Собственный класс исключения
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException() {
        super("invalid phone number");
    }

    public InvalidPhoneNumberException(String message) {
        super(message);
    }

    public InvalidPhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPhoneNumberException(Throwable cause) {
        super(cause);
    }
}

//Пример использования
class PhoneNumberValidator {
    //Метод, который может выбросить собственное исключение
    public static void validateRussianPhoneNumber(String number) throws InvalidPhoneNumberException {
        if (number == null) {
            throw new InvalidPhoneNumberException("phone number cannot be null");
        }
        if (!number.startsWith("+7") | number.length() != 12) {
            throw new InvalidPhoneNumberException("invalid Russian phone number");
        }
        //какие-то еще проверки...
    }
}

//Демонстрация
public class MyExceptionExample {
    public static void main(String[] args) {
        try {
            PhoneNumberValidator.validateRussianPhoneNumber("+7999");
        }
        catch (InvalidPhoneNumberException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}