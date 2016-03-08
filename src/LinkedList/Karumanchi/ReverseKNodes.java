package LinkedList.Karumanchi;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/17/2016.
 */
public class ReverseKNodes {

    public static void main(String a[]) {
        ReverseKNodes rkn = new ReverseKNodes();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);

        ll.setHead(rkn.reverseKNode(ll.getHead(), 3));

        System.out.println(ll);
    }

    public ListNode reverseKNode(ListNode head, int k) {

        if (head == null)
            return null;

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        int i = 0;
        while (i < k && current != null) {
            next = current.getNext();

            current.setNext(previous);

            previous = current;
            current = next;

            i++;
        }
        head.setNext(reverseKNode(next, k));
        return previous;
    }
}
