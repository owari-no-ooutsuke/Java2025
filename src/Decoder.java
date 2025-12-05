import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс для декодирования файлов, закодированных по алгоритму Хаффмана
 */
class Decoder implements HuffmanProcessor {

    private final FileInputStream fin; //входной поток
    private final FileOutputStream fout; //выходной поток

    /**
     * Создает декодировщик для заданных потоков ввода и вывода.
     *
     * @param fin входной поток для чтения закодированных данных
     * @param fout выходной поток для записи декодированных данных
     */
    public Decoder(FileInputStream fin, FileOutputStream fout) {
        this.fin = fin;
        this.fout = fout;
    }

    /**
     * Читает дерево Хаффмана из входного потока.
     *
     * @return корень дерева
     * @throws IOException ошибка чтения или некорректный формат данных
     */
    private Node readTree() throws IOException {
        int marker = fin.read();
        if (marker == 1) { //лист
            int value = fin.read();
            if (value == -1) {
                throw new IOException("");
            }
            return new Node((byte) value, 0);
        } else if (marker == 0) { //внутренний узел
            Node left = readTree();
            Node right = readTree();
            return new Node((byte) 0, 0, left, right);
        } else {
            throw new IOException("Некорректный формат записи дерева!");
        }
    }

    /**
     * Основной метод декодирования
     *
     * @throws IOException если происходит ошибка ввода-вывода
     */
    @Override
    public void process() throws IOException {
        int dataSize = 0;
        for (int i = 0; i < 4; i++) {
            int b = fin.read();
            if (b == -1) {
                throw new IOException("Преждевременный конец файла");
            }
            dataSize = (dataSize << 8) | (b & 0xFF);
        }

        if (dataSize == 0) {
            return;
        }

        Node root = readTree();

        int endMarker = fin.read();
        if (endMarker == -1) {
            throw new IOException("Преждевременный конец файла");
        }
        if (endMarker != 2) {
            throw new IOException("Неверный маркер конца дерева!");
        }

        if (root.isLeaf()) {
            for (int i = 0; i < dataSize; i++) {
                fout.write(root.getValue());
            }
            System.out.println("Декодирование завершено!\n");
            return;
        }

        Node current = root;
        int decodedBytes = 0;

        while (decodedBytes < dataSize) {
            int byteRead = fin.read();
            if (byteRead == -1) {
                throw new IOException("Преждевременный конец файла");
            }
            byte b = (byte) byteRead;

            for (int bitMask = 1 << 7; bitMask > 0 && decodedBytes < dataSize; bitMask >>= 1) {
                boolean bit = (b & bitMask) != 0;
                current = bit ? current.getRight() : current.getLeft();

                if (current.isLeaf()) {
                    fout.write(current.getValue());
                    current = root;
                    decodedBytes++;
                }
            }
        }

        System.out.println("Декодирование завершено!\n");
    }
}