package Trees;

import utils.ds.Tree;
import utils.ds.TreeNode;

/**
 * Created by vrajp on 4/30/2016.
 */
public class LowestCommonAncestor {

    public static void main(String a[]) {
        LowestCommonAncestor lca = new LowestCommonAncestor();

        Tree<Integer> tree = new Tree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(-1);
        tree.insert(-1);
        tree.insert(6);

        System.out.println(lca.lowestCommonAncestor(tree.getRoot(), 7   , 5).getValue());
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root == null)
            return null;

        if (root.getValue() == val1 || root.getValue() == val2)
            return root;

        TreeNode left = lowestCommonAncestor(root.getLeft(), val1, val2);
        TreeNode right = lowestCommonAncestor(root.getRight(), val1, val2);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
