package Trees;

import utils.ds.Tree;
import utils.ds.TreeNode;

/**
 * Created by vrajp on 2/20/2016.
 */
public class TreeSize {

    public static void main(String a[]) {
        TreeSize fs = new TreeSize();

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

        tree.levelOrderTraversal(tree.getRoot());

        System.out.println("Number of Elemets: " + fs.findNumberOfNodes(tree.getRoot()));
        System.out.println("Tree Height: " + fs.findHeight(tree.getRoot()));
        System.out.println("Number of Leaf Nodes: " + fs.findNumberOfLeaf(tree.getRoot()));
        System.out.println("Diameter of a Tree: " + fs.findDiameter(tree.getRoot()).getDiameter());
        System.out.println("All Tree Paths: ");
        fs.allTreePaths(tree.getRoot(), new int[20], 0);
    }

    public int findNumberOfNodes(TreeNode root) {
        if (root == null || root.getValue().equals(-1))
            return 0;

        return findNumberOfNodes(root.getLeft()) + findNumberOfNodes(root.getRight()) + 1;
    }

    public int findHeight (TreeNode root) {
        if (root == null || root.getValue().equals(-1))
            return 0;

        return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
    }

    public int findNumberOfLeaf(TreeNode root) {
        if (root == null || root.getValue().equals(-1))
            return 0;

        if (root.getRight() == null && root.getLeft() == null) {
            return 1;
        }

        return findNumberOfLeaf(root.getLeft()) + findNumberOfLeaf(root.getRight());
    }

    public DiameterWrapper findDiameter (TreeNode root) {
        if (root == null || root.getValue().equals(-1)) {
            return new DiameterWrapper(0,0);
        }
        DiameterWrapper dw = new DiameterWrapper();

        DiameterWrapper left = findDiameter(root.getLeft());
        DiameterWrapper right = findDiameter(root.getRight());

        int diameter = Math.max(left.getDiameter(), right.getDiameter());
        dw.setDiameter(Math.max(diameter, left.getHeight()+right.getHeight()));

        dw.setHeight(Math.max(left.getHeight(), right.getHeight()) + 1);

        return dw;
    }

    public void allTreePaths(TreeNode root, int[] path, int len) {
        if (root == null || root.getValue().equals(-1))
            return;

        path[len++] = (int) root.getValue();

        if ((root.getLeft() == null && root.getRight() == null) || (root.getLeft().getValue().equals(-1) && root.getRight().getValue().equals(-1))) {
            printArray(path, len);
        }
        else {
            allTreePaths(root.getLeft(), path, len);
            allTreePaths(root.getRight(), path, len);
        }
    }

    public void printArray (int[] path, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}

class DiameterWrapper {
    int diameter;
    int height;

    public DiameterWrapper() {
    }

    public DiameterWrapper(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
