/**
 * Узел дерева Хаффмана.
 * Реализует интерфейс Comparable для сравнения узлов по частоте.
 */
class Node implements Comparable<Node> {

    private byte value; //значение в узле
    private int frequency; //частота (символа в случае листа, иначе сумма частот сыновей)
    private Node left; //левый сын
    private Node right; //правый сын

    /**
     * Создает лист.
     *
     * @param value символ (байт), представленный узлом
     * @param frequency частота появления символа в данных
     */
    public Node(byte value, int frequency) {
        this.value = value;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    /**
     * Создает внутренний узел.
     *
     * @param value значение узла
     * @param frequency суммарная частота сыновей
     * @param left левый сын
     * @param right правый сын
     */
    public Node(byte value, int frequency, Node left, Node right) {
        this.value = value;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    /**
     * Проверяет, является ли узел листом.
     *
     * @return true, если лист, иначе false
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }

    /**
     * Сравнивает узлы по частоте
     *
     * @param other другой узел для сравнения
     * @return отрицательное число, если частота текущего узла меньше;
     * положительное, если больше; 0, если равны
     */
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }

    /**
     * Возвращает значение узла.
     *
     * @return байт, представленный узлом
     */
    public byte getValue() {
        return value;
    }

    /**
     * Возвращает частоту узла.
     *
     * @return частота появления символа (байта) (для листа)
     * или сумма частот сыновей (для внутреннего узла)
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Возвращает левого сына
     *
     * @return левый сын или null, если узел является листом
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Возвращает правого сына
     *
     * @return правый сын или null, если узел является листом
     */
    public Node getRight() {
        return right;
    }
}