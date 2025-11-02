public class HttpStatusHandler {

    public enum HttpStatus {
        //Инициализация элементов перечисления
        CONTINUE(100, "Continue"),
        OK(200, "OK"),
        CREATED(201, "Created"),
        ACCEPTED(202, "Accepted"),
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, " Internal Server Error"),
        SERVICE_UNAVAILABLE(503, "Service Unavailable");

        public final int code;
        public final String message;
        public final boolean isSuccessful;

        // Конструктор перечисления
        HttpStatus(int code, String message) {
            this.code = code;
            this.message = message;
            this.isSuccessful = code >= 200 && code < 300;
        }
    }

    //Вывод информации о статусе по коду
    public static void handleResponse(int statusCode) {
        System.out.println("Код " + statusCode);
        for (HttpStatus status : HttpStatus.values()) {
            if (statusCode == status.code) {
                System.out.println("Сообщение " + status.message);
                System.out.println((status.isSuccessful) ? "Успех!\n" : "Ошибка!\n");
                return;
            }
        }
        System.out.println("Неизвестный статус!\n");
    }

    public static void main(String[] args) {
        handleResponse(200);
        handleResponse(404);
        handleResponse(212);
    }
}

