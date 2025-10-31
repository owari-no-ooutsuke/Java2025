package banking.core;

public class Employee {
    private BankAccount account;

    public Employee(BankAccount account) {
        this.account = account;
    }

    public void demonstrateAccess() {
        System.out.println("\n\nEmployee (тот же пакет core):\n");

        //public - доступно
        System.out.println("accountNumber (public): " + account.accountNumber);
        System.out.println("ownerName через геттер: " + account.getOwnerName());

        //protected - доступно
        System.out.println("balance (protected): " + account.balance);
        account.addInterest();

        //default - доступно
        System.out.println("accountType (default): " + account.accountType);
        account.applyFee();

        //private - НЕ доступно
        System.out.println("ownerName (private): недоступен");
        //System.out.println(account.ownerName); //ОШИБКА!
        //account.maskAccount(); //ОШИБКА!
    }
}