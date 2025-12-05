import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Класс для кодирования файлов по алгоритму Хаффмана
 */
class Encoder implements HuffmanProcessor {

    private final FileInputStream fin; //входной поток
    private final FileOutputStream fout; //выходной поток

    /**
     * Создает кодировщик для заданных потоков ввода и вывода.
     *
     * @param fin входной поток для чтения исходных данных
     * @param fout выходной поток для записи закодированных данных
     */
    public Encoder(FileInputStream fin, FileOutputStream fout) {
        this.fin = fin;
        this.fout = fout;
    }

    /**
     * Подсчитывает количества вхождений байтов в данные
     *
     * @param data исходные данные
     * @return Map: ключ - байт, значение - его количество вхождений в исходные данные
     */
    private Map<Byte, Integer> buildFrequencyMap(byte[] data) {
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : data) {
            if (frequencyMap.containsKey(b)) {
                frequencyMap.replace(b, frequencyMap.get(b) + 1);
            }
            else {
                frequencyMap.put(b, 1);
            }
        }
        return frequencyMap;
    }

    /**
     * Строит дерево Хаффмана
     *
     * @param frequencyMap Map: ключ - байт, значение - его количество вхождений в исходные данные
     * @return
     */
    private Node buildTree(Map<Byte, Integer> frequencyMap) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node((byte)0, left.getFrequency() + right.getFrequency(),
                    left, right);
            queue.add(parent);
        }

        return queue.poll();
    }

    /**
     * Строит таблицу кодов Хаффмана на основе дерева.
     *
     * @param codeTreeRoot корень дерева Хаффмана
     * @return Map: ключ - байт, значение - соответствующий ему код Хаффмана
     */
    private Map<Byte, String> buildCodeTable(Node codeTreeRoot) {
        Map<Byte, String> codeTable = new HashMap<>();

        buildCodeTableRecursive(codeTreeRoot, "", codeTable);
        return codeTable;
    }

    /**
     * Рекурсивный метод для построения таблицы кодов.
     *
     * @param node текущий узел дерева
     * @param code текущий код
     * @param codeTable таблица кодов
     */
    private void buildCodeTableRecursive(Node node, String code, Map<Byte, String> codeTable) {
        if (node.isLeaf()) {
            codeTable.put(node.getValue(), code);
        }
        else {
            buildCodeTableRecursive(node.getLeft(), code + "0", codeTable);
            buildCodeTableRecursive(node.getRight(), code + "1", codeTable);
        }
    }

    /**
     * Записывает дерево Хаффмана в выходной поток.
     * Использует префиксный обход.
     * Маркеры: 1 - лист, 0 - внутренний узел.
     *
     * @param node текущий узел для записи
     * @throws IOException если происходит ошибка записи
     */
    private void writeTree(Node node) throws IOException {
        if (node.isLeaf()) {
            fout.write(1);
            fout.write(node.getValue());
        } else {
            fout.write(0);
            writeTree(node.getLeft());
            writeTree(node.getRight());
        }
    }

    /**
     * Преобразует закодированные данные из строки в массив байтов.
     *
     * @param encodedData строка закодированных данных
     * @return закодированные данные в массиве байтов
     */
    private byte[] encodedDataToByteArray(String encodedData) {
        int bitLength = encodedData.length();
        int byteLength;
        if (bitLength % 8 == 0) {
            byteLength = bitLength / 8;
        }
        else {
            byteLength = bitLength / 8 + 1;
        }

        byte[] bytes = new byte[byteLength];

        for (int i = 0; i < bitLength; i++) {
            if (encodedData.charAt(i) == '1') {
                bytes[i / 8] |= (byte) (1 << (7 - (i % 8)));
            }
        }

        return bytes;
    }

    /**
     * Записывает закодированные данные в выходной поток.
     * Формат: [размер исходных данных][дерево Хаффмана][маркер 2][закодированные данные]
     *
     * @param codeTreeRoot корень дерева Хаффмана
     * @param encodedData закодированные данные
     * @param dataSize размер исходных данных в байтах
     * @throws IOException если происходит ошибка записи
     */
    private void writeEncodedData(Node codeTreeRoot, String encodedData, int dataSize) throws IOException {
        fout.write((dataSize >> 24) & 0xFF);
        fout.write((dataSize >> 16) & 0xFF);
        fout.write((dataSize >> 8) & 0xFF);
        fout.write(dataSize & 0xFF);

        if (codeTreeRoot != null) {
            writeTree(codeTreeRoot);
        }

        fout.write(2);

        byte[] encodedBytes = encodedDataToByteArray(encodedData);
        fout.write(encodedBytes);
    }

    /**
     * Основной метод кодирования
     *
     * @throws IOException если происходит ошибка ввода-вывода
     */
    @Override
    public void process() throws IOException {
        byte[] data = fin.readAllBytes();

        if (data.length == 0) {
            return;
        }

        Map<Byte, Integer> frequencyMap = buildFrequencyMap(data);
        Node codeTreeRoot = buildTree(frequencyMap);
        Map<Byte, String> codeTable = buildCodeTable(codeTreeRoot);

        StringBuilder encodedBuilder = new StringBuilder();
        for (byte b : data) {
            String code = codeTable.get(b);
            if (code == null) {
                throw new IOException("Код не найден: " + b);
            }
            encodedBuilder.append(code);
        }

        writeEncodedData(codeTreeRoot, encodedBuilder.toString(), data.length);

        System.out.println("Кодирование завершено!\n");
    }
}