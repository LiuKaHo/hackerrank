package datastruct.tree;

/**
 * @author liukaho
 * @date 2020/6/19 5:12 PM
 */

// left => middle => right
public class InorderTraversal {

    public static void inOrder(Node root) {
        if (root != null){
            inOrder(root.left);
            System.out.printf("%d ", root.data);
            inOrder(root.right);
        }
    }
}
