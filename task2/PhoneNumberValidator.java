public class PhoneNumberValidator {
    //private
    private String russianCountryCode = "+7";

    //по умолчанию
    int numberLength = 10;

    //protected
    protected String[] operatorCodes = {"921", "911", "903"};

    //public
    public void printMessage() {
        System.out.println("Происходит валидация номера..");
    }

    //Внутренний класс
    //Из внутреннего класса доступны все поля и методы внешнего вне зависимости от спецификаторов доступа
    class PhoneNumber {
        private String countryCode;
        private String number;

        public PhoneNumber(String countryCode, String number) {
            this.countryCode = countryCode;
            this.number = number;
        }

        public boolean validate(String countryCode, String number) {
            //Доступ к public методу внешнего класса
            printMessage();

            //Доступ к полю внешнего класса со спецификатором по умолчанию
            if (number.length() != numberLength) {
                return false;
            }

            //Доступ к private полю внешнего класса
            if (!countryCode.equals(russianCountryCode)) {
                return false;
            }

            boolean validOperator = false;
            //Доступ к protected полю внешнего класса
            for (String op : operatorCodes) {
                if (number.startsWith(op)) {
                    validOperator = true;
                }
            }
            if (!validOperator) {
                return false;
            }
            return true;
        }
    }
}
