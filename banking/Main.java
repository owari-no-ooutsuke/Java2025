package banking;

import banking.core.BankAccount;
import banking.core.Employee;
import banking.customer.Customer;
import banking.company.CompanyAccount;

public class Main {
    public static void main(String[] args) {
        //Вывод информации о доступности полей и методов класса BankAccount

        BankAccount account = new BankAccount("1234567890", "SAVINGS", "Иванов Иван Иванович");


        Employee employee = new Employee(account); //класс в том же пакете
        employee.demonstrateAccess();

        CompanyAccount companyAccount = new CompanyAccount("9876543210", //наследник в другом пакете
                "CHECKING", "Петров Петр Петрович");
        companyAccount.demonstrateAccess();


        Customer customer = new Customer(account); //класс в другом пакете (не наследник)
        customer.demonstrateAccess();
    }
}