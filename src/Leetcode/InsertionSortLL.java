package Leetcode;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 3/2/2016.
 */
public class InsertionSortLL {
    public static void main (String[] a) {
        InsertionSortLL rl = new InsertionSortLL();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(5);
        ll.addFirst(4);

        System.out.println(ll);

        ll.setHead(rl.insertionSortList(ll.getHead()));
        System.out.println(ll);
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode sortedList = head;

        if (head == null)
            return head;

        ListNode current = head.getNext();

        while (current != null) {
            ListNode previous = null;
            ListNode nextToPrev = head;
            ListNode next = current.getNext();

            while (nextToPrev != null && nextToPrev != current && (Integer)nextToPrev.getValue() < (Integer)current.getValue()) {
                previous = nextToPrev;
                nextToPrev = nextToPrev.getNext();
            }

            if (previous == null) {
                current.setNext(head);
                head = current;
            } else {
                current.setNext(nextToPrev);
                previous.setNext(current);
            }



            if (nextToPrev.getNext() == current)
                nextToPrev.setNext(null);

            current = next;
        }

        return head;
    }
}
