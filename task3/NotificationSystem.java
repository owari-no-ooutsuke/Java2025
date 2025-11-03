import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {
    private List<Notification> notifications;

    public NotificationSystem() {
        this.notifications = new ArrayList<>();
    }

    //Внутренний класс
    public class Notification {
        //public
        public String title;

        //protected
        protected String message;

        public Notification(String title, String message) {
            this.title = title;
            this.message = message;
        }

        //по умолчанию
        void send() {
            System.out.println("Отправка: " + title);
        }

        //private
        private boolean validate() {
            System.out.println("Валидация: " + title);
            if (title == null || message == null) {
                return false;
            }
            else {
                return true;
            }
        }
    }

    //Из внешнего класса доступны все поля и методы внутреннего вне зависимости от спецификаторов доступа
    public void demoMethod(String title, String message) {
        //Создаем экземпляр внутреннего класса
        Notification notification = new Notification(title, message);

        //Доступ к private методу
        boolean valid = notification.validate();

        if (valid) {
            //Доступ к public полю
            System.out.println("Заголовок: " + notification.title);

            //Доступ к protected полю
            System.out.println("Сообщение: " + notification.message);

            //Доступ к методу со спецификатором по умолчанию
            notification.send();

            notifications.add(notification);
        }
    }
}

