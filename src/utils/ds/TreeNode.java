package utils.ds;

/**
 * Created by vrajp on 2/19/2016.
 */
public class TreeNode <E> {

    private E value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(E value) {
        this.value = value;
        left = null;
        right = null;
    }

    public E getValue() {

        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}
