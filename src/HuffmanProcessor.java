import java.io.IOException;

/**
 * Интерфейс для обработчиков по алгоритму Хаффмана
 */
public interface HuffmanProcessor {
    /**
     * Основная операция обработки
     * @throws IOException при ошибках ввода-вывода
     */
    public void process() throws IOException;
}
