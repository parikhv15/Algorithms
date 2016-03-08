package utils.ds;

/**
 * Created by vrajp on 3/4/2016.
 */
public class Stack<E> {
    private StackNode<E> top;
    private int size = 0;

    public E pop() throws EmptyStackException{
        if (top == null)
            throw new EmptyStackException("Stack is EMpty..");

        E popItem = top.getValue();
        top = top.getNext();
        size--;

        return popItem;
    }

    public void push(E value) {
        StackNode<E> pushItem = new StackNode<>(value);

        push(pushItem);
    }

    public void push(StackNode<E> node) {
        node.setNext(top);
        top = node;
        size++;
    }

    public E peek() throws EmptyStackException{
        if (top == null)
            throw new EmptyStackException("Stack is Empty..");

        return top.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class EmptyStackException extends Exception {
    public EmptyStackException(String message) {
        super(message);
    }
}

class StackNode<E> {
    private E value;
    private StackNode<E> next;

    public StackNode(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public StackNode<E> getNext() {
        return next;
    }

    public void setNext(StackNode<E> next) {
        this.next = next;
    }
}
