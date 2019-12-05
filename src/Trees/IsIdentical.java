package Trees;

import utils.ds.Tree;
import utils.ds.TreeNode;

/**
 * Created by vrajp on 2/20/2016.
 */
public class IsIdentical {

    public static void main(String a[]) {
        IsIdentical ii = new IsIdentical();

        Tree<Integer> tree1 = new Tree<>();
        Tree<Integer> tree2 = new Tree<>();


        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        tree1.insert(4);
        tree1.insert(5);
        tree1.insert(6);
        tree1.insert(7);

        tree2.insert(1);
        tree2.insert(2);
        tree2.insert(3);
        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(6);
        tree2.insert(7);

        System.out.println(ii.isIdentical(tree1.getRoot(), tree2.getRoot()));
    }

    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 == null))
            return true;

        if ((root1 == null || root2 == null) || (root1.getValue().equals(-1) || root2.getValue().equals(-1)))
            return false;

        return root1.getValue() == root2.getValue() &&
                isIdentical(root1.getLeft(), root2.getLeft()) &&
                isIdentical(root1.getRight(), root2.getRight());
    }
}
