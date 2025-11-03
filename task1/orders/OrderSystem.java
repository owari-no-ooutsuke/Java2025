package orders;

public class OrderSystem {
    private static int orderCounter = 0;

    //public внутренний класс
    public class Order {
        protected int orderId;
        protected int amount;

        public Order(int amount) {
            this.orderId = ++orderCounter;
            this.amount = amount;
        }

        public void processOrder() {
            System.out.println("Обработка заказа " + orderId);
        }
    }

    //private внутренний класс
    private class PaymentProcessor {
        private String transactionId;

        private PaymentProcessor() {
            this.transactionId = "";
        }

        private boolean processPayment(Order order, String paymentMethod) {
            System.out.println("Обработка платежа по заказу " + order.orderId + "методом " +
                    paymentMethod);
            return true;
        }
    }

    //protected внутренний класс
    protected class LoyaltyProgram {
        private int points;
        private String customerName;

        public LoyaltyProgram(String customerName) {
            this.customerName = customerName;
            this.points = 0;
        }

        public void addPoints(Order order) {
            points += (int)order.amount;
            System.out.println("Начислено " + points + " бонусных баллов");
        }

        public int getPoints() { return points; }
        public String getCustomerName() { return customerName; }
    }

    //внутренний класс со спецификатором по умолчанию
    class OrderValidator {
        boolean validateOrder(Order order) {
            System.out.println("Валидация заказа " + order.orderId);
            return order.amount > 0;
        }
    }

    public void demoMethod() {

        //public
        Order order = new Order(1);

        //private
        PaymentProcessor processor = new PaymentProcessor();

        //protected
        LoyaltyProgram loyalty = new LoyaltyProgram("DemoCustomer");

        //По умолчанию
        OrderValidator validator = new OrderValidator();
    }
}


