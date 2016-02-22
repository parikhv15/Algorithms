package Trees;

import utils.ds.Tree;
import utils.ds.TreeNode;

/**
 * Created by vrajp on 2/20/2016.
 */
public class PathSum {

    public static void main (String[] a) {
        PathSum ps = new PathSum();


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

        System.out.println(ps.isPathSum(tree.getRoot(), 9));
        System.out.println(ps.getMaxSumPath(tree.getRoot(), 0));
    }

    public int getMaxSumPath (TreeNode root, int sum) {
        if (root == null || root.getValue() == -1)
            return sum;

        int left = getMaxSumPath(root.getLeft(), sum + (int) root.getValue());
        int right = getMaxSumPath(root.getRight(), sum + (int) root.getValue());

        return Math.max(left, right);
    }

    public boolean isPathSum(TreeNode root, int sum) {
       if (root == null && sum == 0)
           return true;

       if (root == null)
           return false;

       return isPathSum(root.getLeft(), sum - (int)root.getValue()) || isPathSum(root.getRight(), sum - (int)root.getValue());
    }
}
