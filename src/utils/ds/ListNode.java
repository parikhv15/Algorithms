package utils.ds;

/**
 * Created by vrajp on 2/13/2016.
 */
public class ListNode<E> {
    private E value;
    private ListNode next;

    public ListNode(E value) {
        this.value = value;
    }

    public ListNode() {
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}