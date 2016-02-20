package LinkedList.Karumanchi;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/18/2016.
 */
public class JosephusCircle {

    public static void main (String a[]) {
        JosephusCircle jc = new JosephusCircle();

        LinkedList<Integer> ll = new LinkedList<>();

        ListNode<Integer> node = new ListNode<>(0);

        ll.add(node);
        for (int i = 1; i < 10; i++) {
            ll.add(i);
        }
        ll.add(node);

        ListNode leader = jc.chooseLeader(ll.getHead(), 2);

        System.out.println(leader.getValue());
    }

    public ListNode chooseLeader(ListNode head, int m) {
        ListNode current = head;
        while (current != current.getNext()) {
            for (int i = 0; i < m; i++) {
                current = current.getNext();
            }
//            System.out.println(current.getValue());
            current.setNext(current.getNext().getNext());
        }
        return current;
    }
}
