package LinkedList.Karumanchi;

import utils.ds.LinkedList;
import utils.ds.ListNode;

import java.util.List;

/**
 * Created by vrajp on 2/17/2016.
 */
public class ReversePair {

    public static void main(String a[]) {
        ReversePair rp = new ReversePair();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);


        System.out.println(ll);

//        ll.setHead(rp.reversePair(ll.getHead()));

        ll.setHead(rp.reversePairSol(ll.getHead()));

        System.out.println(ll);
    }

    public ListNode reversePair(ListNode head) {
        ListNode newHead = null;
        ListNode previous = head;
        ListNode current = previous.getNext();
        ListNode next = current.getNext();

        while (next != null) {
            current.setNext(previous);
            if (next.getNext() != null)
                previous.setNext(next.getNext());
            else
                previous.setNext(next);

            if (newHead == null)
                newHead = current;

            previous = next;
            current = previous.getNext();

            if (current != null)
                next = current.getNext();
            else
                break;
        }
        if (next == null) {
            previous.setNext(next);
            current.setNext(previous);
        }

        return newHead;
    }

    public ListNode reversePairSol(ListNode head) {
        ListNode newHead = null;
        ListNode current = head;
        ListNode next = null;
        ListNode beyond = null;
        ListNode previous = null;

        while (current != null && current.getNext() != null) {
            next = current.getNext();
            beyond = next.getNext();

            next.setNext(current);
            current.setNext(beyond);

            if (newHead == null)
                newHead = next;

            if (previous != null)
                previous.setNext(next);

            previous = current;

            if (current != null)
                current = current.getNext();
        }

        return newHead;
    }
}
