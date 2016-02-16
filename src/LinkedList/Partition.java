package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/16/2016.
 */
public class Partition {

    public static void main(String a[]) {
        Partition p = new Partition();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(4);
        ll.add(2);
        ll.add(5);

        ListNode part = p.partitionLinkedList(ll.getHead(), 3);

        while (part != null) {
            System.out.print(part.getValue() + " -> ");
            part = part.getNext();
        }
    }

    public ListNode partitionLinkedList(ListNode node, int x) {
        ListNode low = node;
        ListNode high = node;

        while (node != null) {
            ListNode nextNode = node.getNext();

            if ((int) node.getValue() < x) {
                node.setNext(low);
                low = node;
            }
            else {
                high.setNext(node);
                high = node;
            }
            node = nextNode;
        }
        high.setNext(null);

        return low;
    }
}
