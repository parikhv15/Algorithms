package utils.ds;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by vrajp on 2/19/2016.
 */
public class Tree<E> {
    private TreeNode<E> root;

    public void insert (E value) {
        TreeNode nodeToInsert = new TreeNode(value);

        insert(nodeToInsert);
    }

    public void insert (TreeNode nodeToInsert) {
        if (root == null) {
            root = nodeToInsert;
            return;
        }
        else {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                else {
                    node.setLeft(nodeToInsert);
                    return;
                }

                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
                else {
                    node.setRight(nodeToInsert);
                    return;
                }
            }
        }
    }

    public void preOrderTraversal (TreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    public void postOrderTraversal (TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    public void inOrderTraversal (TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderTraversal(root.getRight());
        }
    }

    public void levelOrderTraversal (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();

                System.out.print(node.getValue() + " ");
                size--;

                if (node.getLeft() != null && node.getLeft().getValue() != -1) {
                    queue.offer(node.getLeft());
                }

                if (node.getRight() != null  && node.getRight().getValue() != -1) {
                    queue.offer(node.getRight());
                }

                if (size == 0)
                    System.out.println();
            }
        }
        System.out.println();
    }

    public void preOrderTraversalItr (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (true) {
            while (node != null) {
                System.out.print(node.getValue() + " ");
                stack.push(node);
                node = node.getLeft();
            }

            if (stack.isEmpty())
                break;

            node = stack.pop();
            node = node.getRight();
        }
        System.out.println();
    }

    public void inOrderTraversalItr (TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            if (stack.isEmpty())
                break;

            node = stack.pop();
            System.out.print(node.getValue() + " ");
            node = node.getRight();
        }
        System.out.println();
    }

    public void postOrderTraversalItr (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            else {
                if (stack.isEmpty())
                    break;

                if (stack.peek().getRight() == null) {
                    node = stack.pop();
                    System.out.print(node.getValue() + " ");
                    if (stack.peek().getRight() == node) {
                        System.out.print(stack.pop().getValue() + " ");
                    }
                }

                if (!stack.isEmpty())
                    node = stack.peek().getRight();
                else
                    node = null;
            }
        }
    }
    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
}