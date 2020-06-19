package datastruct.tree;

/**
 * @author liukaho
 * @date 2020/6/19 5:09 PM
 */

// left => right => middle
public class PostorderTraversal {

    public static void postOrder(Node root) {
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ", root.data);
        }
    }
}
