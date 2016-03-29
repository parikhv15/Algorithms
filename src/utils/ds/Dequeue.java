package utils.ds;

/**
 * Created by vrajp on 3/22/2016.
 */
public class Dequeue<E> {
    private DQNode front, rear = null;
    private int size = 0;

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public void insertToFront(E value) {
        DQNode<E> node = new DQNode<>(value);

        insertToFront(node);
    }

    public void insertToFront(DQNode node) {
        if (front == null) {
            front = node;
            rear = front;
        } else {
            node.next = front;
            front = node;
        }

        size++;
    }

    public void insertToRear (E value) {
        DQNode<E> node = new DQNode<>(value);

        insertToFront(node);
    }
//    public void insertToRear (DQNode node) {
//        if (rear == null) {
//            rear = node;
//            front = rear;
//        } else {
//            rear.next =
//        }
//    }
}

class DQNode<E> {
    E value;
    DQNode next;

    protected DQNode(E value) {
        this.value = value;
    }
}
