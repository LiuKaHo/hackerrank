package datastruct.tree;

/**
 * @author liukaho
 * @date 2020/6/19 5:15 PM
 */

// height = node - 1
public class HeightofaBinaryTree {

    public static int height(Node root) {
        if (root == null){
            return -1;
        }

        return Math.max(height(root.left)+1, height(root.right)+1);
    }
}
