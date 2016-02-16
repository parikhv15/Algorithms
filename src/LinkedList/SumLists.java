package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/16/2016.
 */
public class SumLists {

    public static void main (String a[]) {
        SumLists sl = new SumLists();

        LinkedList<Integer> ll1 = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();

        ll1.add(6);
        ll1.add(1);
        ll1.add(7);
        ll1.add(0);

        ll2.add(2);
        ll2.add(9);
        ll2.add(5);

//        ListNode sum = sl.backwardOrderSum(ll1.getHead(), ll2.getHead(), 0);

        ListNode sum = sl.forwardOrderSum(ll1.getHead(), ll2.getHead());
        while (sum != null) {
            System.out.print(sum.getValue() + " -> ");
            sum = sum.getNext();
        }
    }

    public ListNode backwardOrderSum(ListNode node1, ListNode node2, int carry) {
        if (node1 == null && node2 == null && carry == 0)
            return null;

        int value = carry;
        ListNode sum = new ListNode();

        if (node1 != null)
            value += (int) node1.getValue();

        if (node2 != null)
            value += (int) node2.getValue();

        sum.setValue(value % 10);

        if (node1 != null || node2 != null) {
            sum.setNext(backwardOrderSum(node1 == null ? null : node1.getNext(), node2 == null ? null : node2.getNext(), value / 10));
        }

        return sum;
    }

    public ListNode forwardOrderSum(ListNode node1, ListNode node2) {
        int length1 = length(node1);
        int length2 = length(node2);

        if (length1 < length2)
            node1 = padList(node1, length2 - length1);
        else if (length2 < length1)
            node2 = padList(node2, length1 - length2);

        SumWrapper sum = forwardOrderSumHelper(node1, node2);

        return sum.sum;
    }

    public SumWrapper forwardOrderSumHelper(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return new SumWrapper();
        }

        SumWrapper sum = forwardOrderSumHelper(node1.getNext(), node2.getNext());

        int value = sum.carry + (int) node1.getValue() + (int) node2.getValue();

        ListNode nodeToAdd = new ListNode(value % 10);
        nodeToAdd.setNext(sum.sum);

        sum.sum = nodeToAdd;
        sum.carry = value / 10;

        return sum;
    }

    public ListNode padList(ListNode node, int padding) {
        ListNode head = node;

        for (int i = 0 ; i < padding ; i++) {
            head = insertBefore(head, 0);
        }

        return head;
    }

    public ListNode insertBefore(ListNode head, int data) {
        ListNode nodeToInsert = new ListNode(data);

        nodeToInsert.setNext(head);

        return nodeToInsert;
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

class SumWrapper {
    public ListNode sum = null;
    public int carry = 0;
}
