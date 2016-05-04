package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vrajp on 4/28/2016.
 */
public class EchoCartesian {

    public static void main(String[] a) {
        EchoCartesian ec = new EchoCartesian();

        System.out.println(ec.getCartesian("y{x,a{b,c{d,e}h}f"));
    }

    public List<String> getCartesian(String s) {
        boolean[] visited = new boolean[s.length()];

        Node root = new Node("#");
        ArrayList<String> list = new ArrayList<>();

        createCartesianTree(s, 0, visited, root);
        getPaths(root, list, "");

        return list;
    }

    public void getPaths(Node root, ArrayList<String> list, String s) {

        for (Node child : root.children) {
            getPaths(child, list, s+child.val);
        }

        list.add(s);
    }

    public void createCartesianTree(String s, int index, boolean[] visited, Node root) {
        if (index >= s.length())
            return;

        Node tempNode = null;
        for (int i = index; i < s.length(); i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            char ch = s.charAt(i);

            if (ch == '{') {
                if (tempNode == null) {
                    root.children.add(new Node(""));
                }

                tempNode = root.children.getLast();

                createCartesianTree(s, i+1, visited, tempNode);
            } else if (ch == '}') {
                break;
            } else if (ch == ',') {
                tempNode = null;
            }
            else if (Character.isAlphabetic(ch)) {
                if (tempNode != null)
                    tempNode.val = tempNode.val + ch;
                else {
                    tempNode = new Node("" + ch);
                    root.children.add(tempNode);
                }
            }
        }
    }

}

class Node {
    String val;
    LinkedList<Node> children;

    Node(String val) {
        this.val = val;
        children = new LinkedList<>();
    }
}
