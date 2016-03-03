package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/13/2016.
 */
public class ReturnKthToLast {
    public static void main (String[] a) {
        ReturnKthToLast rl = new ReturnKthToLast();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(5);
        ll.addFirst(4);

        System.out.println(ll);

//        ll.setHead(rl.insertionSortList(ll.getHead()));
//        System.out.println(ll);
    }

    public int returnKthLast(ListNode head, int k) {
        ListNode firstPtr = head;
        ListNode secondPtr = head;

        while (k > 1) {
            secondPtr = secondPtr.getNext();
            k--;
        }

        while (secondPtr.getNext() != null) {
            firstPtr = firstPtr.getNext();
            secondPtr = secondPtr.getNext();
        }

        return (Integer) firstPtr.getValue();
    }
}
