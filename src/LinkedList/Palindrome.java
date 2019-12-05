package LinkedList;

import utils.ds.LinkedList;
import utils.ds.ListNode;

import java.util.Stack;

/**
 * Created by vrajp on 2/16/2016.
 */
public class Palindrome {

    public static void main (String[] a) {
        Palindrome p = new Palindrome();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(1);
        ll.add(2);
        ll.add(1);

        System.out.println(p.isPalindromeIterative(ll.getHead()));
        System.out.println(p.isPalindromeRecursive(ll.getHead(), p.length(ll.getHead())).valid);
    }

    public boolean isPalindromeIterative(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.getNext() != null) {
            stack.push((int) slow.getValue());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            int top = stack.peek();

            if (slow.getValue().equals(top))
                return false;

            stack.pop();
            slow = slow.getNext();
        }
        return true;
    }

    public PalindromeWrapper isPalindromeRecursive(ListNode head, int length) {
        if (head == null || length <= 0)
            return new PalindromeWrapper(head, true);

        if (length == 1)
            return new PalindromeWrapper(head.getNext(), true);

        PalindromeWrapper pw = isPalindromeRecursive(head.getNext(), length - 2);

        if (!pw.valid || pw.node == null) {
            return pw;
        }

        if (head.getValue() != pw.node.getValue())
            pw.valid = false;

        pw.node = pw.node.getNext();

        return pw;
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

class PalindromeWrapper {
    public ListNode node;
    public boolean valid;

    public PalindromeWrapper(ListNode node, boolean valid) {
        this.node = node;
        this.valid = valid;
    }
}
