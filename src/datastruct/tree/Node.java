package datastruct.tree;

/**
 * @author liukaho
 * @date 2020/6/19 5:05 PM
 */

public class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
