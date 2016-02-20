package LinkedList.Karumanchi;

import utils.ds.LinkedList;
import utils.ds.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrajp on 2/17/2016.
 */
public class SplitCircularList {

    public static void main (String a[]) {
        SplitCircularList scl = new SplitCircularList();

        LinkedList<Integer> ll = new LinkedList<>();

        ListNode node = new ListNode(1);

        ll.add(node);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(node);

        List<ListNode> splits = scl.splitCircularList(ll.getHead());

        for (ListNode head : splits) {
            scl.print(head);
        }
    }

    public void print (ListNode head) {

        ListNode current = head;

        while (true) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();

            if (current == head)
                break;
        }
        System.out.println();
    }

    public List<ListNode> splitCircularList(ListNode head) {
        List<ListNode> splits = new ArrayList<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast.getNext() != head && fast.getNext().getNext() != head) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast.getNext().getNext() == head)
            fast = fast.getNext();

        ListNode head1 = head;
        ListNode head2 = slow.getNext();

        slow.setNext(head1);
        fast.setNext(head2);

        splits.add(head1);
        splits.add(head2);

        return splits;
    }
}


