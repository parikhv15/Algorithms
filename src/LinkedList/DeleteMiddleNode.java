package LinkedList;


import utils.ds.LinkedList;
import utils.ds.ListNode;

/**
 * Created by vrajp on 2/15/2016.
 */
public class DeleteMiddleNode {

    public static void main(String ap[]) {
        DeleteMiddleNode dm = new DeleteMiddleNode();

        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

//        ll.removeLast();
        dm.deleteNode(ll.getHead().getNext().getNext());

        System.out.println(ll);
    }

    public boolean deleteNode(ListNode node) {
        if (node == null || node.getNext() == null)
            return false;

        ListNode nextNode = node.getNext();
        node.setValue(nextNode.getValue());
        node.setNext(nextNode.getNext());

        return true;
    }
}
