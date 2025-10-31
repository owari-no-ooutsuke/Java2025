package banking.customer;

import banking.core.BankAccount;

public class Customer {
    private BankAccount account;

    public Customer(BankAccount account) {
        this.account = account;
    }

    public void demonstrateAccess() {
        System.out.println("\n\nCustomer (другой пакет customer):\n");

        //public - доступно
        System.out.println("accountNumber (public): " + account.accountNumber);
        System.out.println("ownerName через геттер: " + account.getOwnerName());

        //protected - НЕ доступно
        System.out.println("balance (protected): недоступен");
        //account.balance = 2000; //ОШИБКА!
        //account.addInterest();  //ОШИБКА!

        //default - НЕ доступно
        System.out.println("accountType (default): недоступен");
        //System.out.println(account.accountType); //ОШИБКА!
        //account.applyFee(); //ОШИБКА!

        //private - НЕ доступно
        System.out.println("ownerName (private): недоступен");
        //System.out.println(account.ownerName); //ОШИБКА!
    }
}