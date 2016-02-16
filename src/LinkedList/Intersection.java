package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/16/2016.
 */
public class Intersection {

    public static void main(String a[]) {
        Intersection i = new Intersection();

        LinkedList<Integer> ll1 = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();

        ListNode common = new ListNode(7);
        common.setNext(new ListNode(2));
        common.setNext(new ListNode(1));

        ll1.add(3);
        ll1.add(1);
        ll1.add(5);
        ll1.add(9);

        ll2.add(4);
        ll2.add(6);

        ll1.add(common);
        ll2.add(common);

        System.out.println(i.getIntersection(ll1.getHead(), ll2.getHead()).getValue());

    }

    public ListNode getIntersection(ListNode node1, ListNode node2) {
        int length1 = length(node1);
        int length2 = length(node2);

        ListNode tail1 = tail(node1);
        ListNode tail2 = tail(node2);

        if (tail1 != tail2)
            return null;

        ListNode shorter = length1 > length2 ? node2 : node1;
        ListNode longer = length1 < length2 ? node2 : node1;

        int diff = length1 > length2 ? length1 - length2 : length2 - length1;

        longer = getKthNode(longer, diff);

        while (shorter != longer) {
            shorter = shorter.getNext();
            longer = longer.getNext();
        }

        return longer;
    }

    public ListNode getKthNode(ListNode node, int diff) {
        while (diff > 0 && node != null) {
            node = node.getNext();
            diff--;
        }

        return node;
    }

    public ListNode tail(ListNode node) {

        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node;
    }

    public int length(ListNode node) {
        int length = 0;

        while (node != null) {
            length++;
            node = node.getNext();
        }

        return length;
    }
}
