package datastruct.tree;

/**
 * @author liukaho
 * @date 2020/6/19 5:05 PM
 */

// middle => left => right
public class PreorderTraversal {

    /**
     * class Node {
     *     int data;
     *     Node left;
     *     Node right;
     * }
     *
     */
    public static void preOrder(Node root) {
        if (root != null){
            System.out.printf("%d ",root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
