package Trees;

import utils.ds.Tree;
import utils.ds.TreeNode;

/**
 * Created by vrajp on 2/19/2016.
 */
public class MaximumElement {

    public static void main(String[] a) {
        MaximumElement me = new MaximumElement();

        Tree<Integer> tree = new Tree<>();

        tree.insert(11);
        tree.insert(2);
        tree.insert(31);
        tree.insert(4);

        tree.levelOrderTraversal(tree.getRoot());

        System.out.println(me.getMaximum(tree.getRoot()));
    }

    public int getMaximum(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        if (root.getLeft() == null && root.getRight() == null)
            return (int) root.getValue();
        else {
            int max = Math.max(getMaximum(root.getLeft()), getMaximum(root.getRight()));
            return Math.max(max, (int)root.getValue());
        }
    }
}
