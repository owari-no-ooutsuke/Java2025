public class CurrencyConverter {

    // Перечисление валют с курсами
    public enum Currency {
        RUB("Российский рубль", "₽", 1.0),
        USD("Доллар США", "$", 80.8861),
        EUR("Евро", "€", 93.3848),
        GBP("Фунт стерлингов", "£", 106.341),
        JPY("Японская йена", "¥", 0.5253),
        CNY("Китайский юань", "¥", 11.2449);

        private final String name;
        private final String symbol;
        private final double rateInRUB; // Курс в RUB

        Currency(String name, String symbol, double rateInRUB) {
            this.name = name;
            this.symbol = symbol;
            this.rateInRUB = rateInRUB;
        }

        // Геттеры
        public String getName() { return name; }
        public String getSymbol() { return symbol; }
        public double getRateInRUB() { return rateInRUB; }

        //Конвертация в валюту target
        public double convertTo(double amount, Currency target) {
            return amount * this.rateInRUB / target.rateInRUB;
        }

        //Получение курса в валюте target
        public double getExchangeRate(Currency target) {
            return this.rateInRUB / target.rateInRUB;
        }
    }

    //Демонстрация работы методов
    public static void main(String[] args) {
        double amountInCNY = 100.0;
        double amountInRUB = Currency.CNY.convertTo(amountInCNY, Currency.RUB);
        System.out.println("Конвертация " + Currency.CNY.getName() + " -> " + Currency.RUB.getName() +
                ": " + amountInCNY + Currency.CNY.getSymbol() + " = " + amountInRUB +
                Currency.RUB.getSymbol());

        double USDinJPY = Currency.USD.getExchangeRate(Currency.JPY);
        System.out.println("Курс " + Currency.USD.getName() + " в " + Currency.JPY.getName() +
                ": 1" + Currency.USD.getSymbol() + " = " + USDinJPY + Currency.JPY.getSymbol());
    }
}
