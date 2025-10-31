package banking.company;

import banking.core.BankAccount;

// Наследник в другом пакете
public class CompanyAccount extends BankAccount {

    public CompanyAccount(String accountNumber, String accountType, String ownerName) {
        super(accountNumber, accountType, ownerName);
    }

    public void demonstrateAccess() {
        System.out.println("\n\nCompanyAccount (наследник в другом пакете company):\n");

        //public - доступно
        System.out.println("accountNumber (public): " + accountNumber);
        System.out.println("ownerName через геттер: " + getOwnerName());

        //protected - доступно
        System.out.println("balance (protected): " + balance);
        addInterest();

        //default - НЕ доступно
        System.out.println("accountType (default): недоступен");
        //System.out.println(accountType); //ОШИБКА!
        //applyFee(); //ОШИБКА!

        //private - НЕ доступно
        System.out.println("ownerName (private): недоступен");
        //System.out.println(ownerName); //ОШИБКА!
    }
}