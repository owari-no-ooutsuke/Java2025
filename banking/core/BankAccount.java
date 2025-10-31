package banking.core;

public class BankAccount {
    //Доступно везде
    public String accountNumber;

    //Доступно в пакете core и наследникам в других пакетах
    protected double balance;

    //Доступно только в пакете core
    String accountType;

    //Доступно только в этом классе
    private String ownerName;

    public BankAccount(String accountNumber, String accountType, String ownerName) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    //Метод доступен только в пакете core и наследникам в других пакетах
    protected void addInterest() {
        balance += 100;
        System.out.println("Начислены проценты: +100 руб. (protected)");
    }

    //Метод доступен только в пакете core
    void applyFee() {
        balance -= 50;
        System.out.println("Списана комиссия: -50 руб. (default)");
    }

    //Метод доступен везде
    public String getOwnerName() {
        return ownerName;
    }
}