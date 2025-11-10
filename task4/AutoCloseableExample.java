//Класс, реализующий интерфейс AutoCloseable
class DatabaseConnection implements AutoCloseable {
    private String database;

    public DatabaseConnection(String database) {
        this.database = database;
    }

    public void connect() {
        if (database != null) {
            System.out.println("Соединение установлено");
        }
        else {
            System.out.println("Не удалось установить соединение");
            throw new IllegalStateException("database cannot be null");
        }
    }

    @Override
    public void close() {
        System.out.println("Соединение закрыто\n");
    }
}

public class AutoCloseableExample {
    public static void main(String[] args) {
        String[] databases = {"database.db", null};

        //В первом случае исключения не будет, во втором connect() выбросит IllegalStateException
        //В обоих случаях автоматически будет вызван метод close()
        for (String dbName : databases) {
            try (DatabaseConnection db = new DatabaseConnection(dbName)) {
                db.connect();
                System.out.println("Работаем с базой данных...");
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
