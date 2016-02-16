package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/16/2016.
 */
public class LoopDetection {

    public static void main(String a[]) {
        LoopDetection ld = new LoopDetection();

        LinkedList<Integer> ll = new LinkedList<>();

        ListNode node = new ListNode(5);

        ll.add(1);
        ll.add(2);
        ll.add(node);
        ll.add(3);
        ll.add(4);
        ll.add(node);

        System.out.println(ld.getLoopStart(ll.getHead()).getValue());
    }

    public ListNode getLoopStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        slow = detectLoop(slow, fast);

       if (slow != null) {

           while (slow != fast) {
               slow = slow.getNext();
               fast = fast.getNext();
           }
           return fast;
       }

        return null;
    }

    public ListNode detectLoop(ListNode slow, ListNode fast) {
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (fast == slow)
                return fast;
        }
        return  null;
    }
}
