package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

import java.util.HashSet;

/**
 * Created by vrajp on 2/13/2016.
 */
public class RemoveDups{
    public static void main (String a[]) throws Exception {
        RemoveDups rd = new RemoveDups();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(1);

        rd.removeDups(ll.getHead());

        System.out.println(ll);
    }

    // Time Comlexity - O (n)
    // Space Complexity - O (n)
    public void removeDups(ListNode head) {
        HashSet<Integer> uniqueValues = new HashSet<>();

        ListNode<Integer> current = head.getNext();
        ListNode<Integer> previous = head;

        while (current != null) {
            if (uniqueValues.contains(current.getValue())) {
                // removeNode();
                previous.setNext(current.getNext());
                current = previous.getNext();
            }
            else {
                uniqueValues.add(current.getValue());
                current = current.getNext();
                previous = previous.getNext();
            }
        }
    }
}
