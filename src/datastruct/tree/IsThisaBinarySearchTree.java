package datastruct.tree;

import java.util.Stack;

/**
 * @author liukaho
 * @date 2020/6/21 1:48 PM
 */

public class IsThisaBinarySearchTree {
    boolean checkBST(Node root) {
        return checkNode(root, null, null);
    }


    boolean checkNode(Node root, Integer lower, Integer upper){
        if (root == null) {
            return true;
        }

        if (lower != null && root.data <= lower){
            return false;
        }

        if (upper != null && root.data >= upper){
            return false;
        }
        return checkNode(root.left, lower, root.data) && checkNode(root.right, root.data, upper);
    }



    boolean checkNodeWithStack(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        int preview = -1;
        while (!nodeStack.empty() || root != null) {
            while (root.left != null){
                nodeStack.push(root.left);
                root = root.left;
            }

            root = nodeStack.pop();
            if (root.data <= preview){
                return false;
            }

            preview = root.data;

            root = root.right;
        }

        return true;
    }



}
