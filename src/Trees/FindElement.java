package Trees;

import utils.ds.Tree;
import utils.ds.TreeNode;

/**
 * Created by vrajp on 2/20/2016.
 */
public class FindElement {

    public static void main(String a[]) {
        FindElement fe = new FindElement();

        Tree<Integer> tree = new Tree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(-1);
        tree.insert(-1);
        tree.insert(-1);
        tree.insert(5);

        tree.levelOrderTraversal(tree.getRoot());

        System.out.println(fe.findElement(tree.getRoot(), 6));
    }

    public boolean findElement (TreeNode root, int x) {
        if (root == null) {
            return false;
        }

        if ((int) root.getValue() == x)
            return true;
        else
            return (findElement(root.getLeft(), x) || findElement(root.getRight(), x));
    }
}
