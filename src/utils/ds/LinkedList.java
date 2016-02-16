package utils.ds;

/**
 * Created by vrajp on 2/13/2016.
 */
public class LinkedList<E> {

    private ListNode head;
    private int count;

    public LinkedList() {
        count = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void add(E val, int index) throws InvalidIndexException {
        ListNode<E> nodeToAdd = new ListNode<>(val);

        add(nodeToAdd, index);
    }

    public void add(ListNode<E> nodeToAdd, int index) throws InvalidIndexException {
        if (index > count + 1)
            throw new InvalidIndexException("Invalid Index");

        int tempCount = 0;

        ListNode<E> currentNode = head;
        ListNode<E> previousNode = null;

        while (tempCount < index - 1) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            tempCount++;
        }
        nodeToAdd.setNext(currentNode);

        if (index == 1) {
            head = nodeToAdd;
        } else {
            previousNode.setNext(nodeToAdd);
        }

        count++;
    }

    public void addFirst (E val) {
        ListNode<E> nodeToAdd = new ListNode<>(val);

        addFirst(nodeToAdd);
    }

    public void addFirst(ListNode<E> nodeToAdd) {
        ListNode<E> currentNode = head;

        nodeToAdd.setNext(currentNode);
        head = nodeToAdd;

        count++;
    }

    public void add(E val) {
        ListNode<E> nodeToAdd = new ListNode<>(val);

        add(nodeToAdd);
    }

    public void add(ListNode<E> nodeToAdd) {
        if (head == null) {
            head = nodeToAdd;
        }
        else {
            ListNode<E> current = head;

            while (current.getNext() != null)
                current = current.getNext();

            current.setNext(nodeToAdd);
        }

        count++;
    }

    public ListNode remove(int index) throws InvalidIndexException {
        if (index > count)
            throw new InvalidIndexException("Invalid Index");

        ListNode<E> currentNode = head;
        ListNode<E> previousNode = null;

        int tempCount = 0;

        while (tempCount < index - 1) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            tempCount++;
        }

        if (index == 1)
            head = head.getNext();
        else
            previousNode.setNext(currentNode.getNext());

        count--;

        return currentNode;
    }

    public ListNode removeFirst() {
        ListNode<E> currentNode = head;

        head = head.getNext();

        count--;

        return currentNode;
    }

    public ListNode removeLast() {
        ListNode<E> currentNode = head;
        ListNode<E> nextNode = currentNode.getNext();

        while (nextNode.getNext() != null) {
            currentNode = currentNode.getNext();
            nextNode = nextNode.getNext();
        }

        currentNode.setNext(nextNode.getNext());

        count--;

        return nextNode;
    }


    public int size() {
        return count;
    }

    public String toString() {
        ListNode<E> node = head;
        String s = "";

       s += "head -> ";
        while(node != null) {
            s += node.getValue() + " -> ";
            node = node.getNext();
        }
        s += "null";

        return s;
    }
}

class InvalidIndexException extends Exception {
    public InvalidIndexException(String message) {
        super(message);
    }
}
