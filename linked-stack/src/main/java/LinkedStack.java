import java.util.ArrayList;
import java.util.List;

public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value);
        if (tail != null) {
            node.setPrev(tail);
        }
        tail = node;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Попытка извлечь значение из пустого стэка");
        }

        int value = tail.getValue();
        tail = tail.getPrev();
        size--;

        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "EMPTY";
        }

        List<String> values = new ArrayList<>(getSize());
        Node cur = tail;
        while (cur != null) {
            values.add(String.valueOf(cur.getValue()));
            cur = cur.getPrev();
        }

        return String.join(" -> ", values);
    }
}
