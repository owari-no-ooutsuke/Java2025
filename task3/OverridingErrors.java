class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Снято: " + amount);
            return true;
        }
        return false;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    //С @Override компилятор проверяет, существует ли в суперклассе метод с такой сигнатурой
    //Это позволяет обнаруживать следующие ошибки:

    //Опечатка в названии метода
    //Без @Override код скомпилируется, но depsit(double amount) будет новым методом, а не переопределенным
    @Override
    public void depsit(double amount) { //Должно быть deposit
        if (amount > 0) {
            balance += amount + (amount * interestRate);
            System.out.println("Внесено с процентами: " + amount);
        }
    }

    //Ошибка в сигнатуре метода
    //Без @Override код скомпилируется, но создастся перегруженный метод вместо переопределенного
    @Override
    public boolean withdraw(int amount) { //Должно быть double amount
        System.out.println("Попытка снять: " + amount);
        return super.withdraw(amount);
    }
}
