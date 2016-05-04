package LinkedList.Karumanchi;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/17/2016.
 */
public class ReverseList {

    public static void main(String a[]) {
        ReverseList rl = new ReverseList();

        LinkedList ll = new LinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        System.out.println(ll);

        ll.setHead(rl.reverseList(ll.getHead()));

        System.out.println(ll);
    }

    public ListNode reverseList (ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode nextNode = current.getNext();

            current.setNext(previous);
            previous = current;

            current = nextNode;
        }

        return previous;
    }
}
