package ordersDemo;

import orders.OrderSystem;

//Наследник в другом пакете - доступны public и protected внутренние классы
class PremiumOrderSystem extends OrderSystem {

    public void childDemoMethod(String customerName, int amount) {
        //public
        Order order = new Order(amount);

        //protected
        LoyaltyProgram loyalty = new LoyaltyProgram(customerName);
        loyalty.addPoints(order);

        //По умолчанию недоступен, т.к. другой пакет
        //OrderValidator validator = new OrderValidator(); //Ошибка компиляции!

        //private недоступен
        //PaymentProcessor processor = new PaymentProcessor(); //Ошибка компиляции!
    }
}

//Не наследник, другой пакет - доступны только public
public class OrderSystemDemo {
    public static void main(String[] args) {
        OrderSystem system = new OrderSystem();

        //public
        OrderSystem.Order order = system.new Order(2);
        order.processOrder();

        //private недоступен
        //OrderSystem.PaymentProcessor processor = system.new PaymentProcessor(); //Ошибка компиляции!

        //По умолчанию недоступен из другого пакета
        //OrderSystem.OrderValidator validator = system.new OrderValidator(); //Ошибка компиляции!

        //protected недоступен, если класс в другом пакете не наследник
        //OrderSystem.LoyaltyProgram loyalty = system.new LoyaltyProgram("Customer"); //Ошибка компиляции!
    }
}

